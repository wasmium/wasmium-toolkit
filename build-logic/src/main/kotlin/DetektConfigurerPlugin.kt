package build.gradle.plugins.build

import kotlin.jvm.java
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.StopExecutionException
import org.gradle.kotlin.dsl.assign
import org.jetbrains.kotlin.com.intellij.openapi.util.text.HtmlChunk.html
import org.jetbrains.kotlin.org.apache.commons.compress.harmony.pack200.PackingUtils.config

public class DetektConfigurerPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = project.run {
        if (rootProject != this) {
            throw StopExecutionException("Gradle wrapper plugin should only be applied to the root project.")
        }

        if (!project.plugins.hasPlugin(DetektPlugin::class.java)) {
            throw StopExecutionException("$PLUGIN_ID plugin requires $DETEKT_PLUGIN_ID plugin to be applied.")
        }

        tasks.register("detektAll", Detekt::class.java) {
            group = "Verification"
            description = "Run all detekt tasks"

            setSource(projectDir)

            buildUponDefaultConfig = true
            parallel = true
            config.setFrom(layout.files("gradle/detekt/detekt.yml"))

            include("**/*.kt", "**/*.kts")
            exclude("**/resources/**", "**/build/**", "**/build.gradle.kts", "**/settings.gradle.kts")
            reports {
                xml.required = false
                html.required = false
            }
        }
    }

    public companion object {
        public const val PLUGIN_ID: String = "build-detekt-configurer"
        public const val DETEKT_PLUGIN_ID: String = "io.gitlab.arturbosch.detekt"
    }
}
