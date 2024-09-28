import org.jetbrains.dokka.DokkaConfiguration.Visibility
import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    alias(libraries.plugins.dokka.gradle.plugin)
    alias(libraries.plugins.kotlinx.kover)

    id("build-project-default")
    id("build-multiplatform")
    id("build-publishing")
}

kotlin {
    explicitApi()

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.ExperimentalStdlibApi")
                optIn("kotlin.RequiresOptIn")
                optIn("kotlin.contracts.ExperimentalContracts")
                optIn("kotlin.time.ExperimentalTime")
            }
        }

        val commonMain by getting {
            kotlin {
                srcDirs("src/commonMain/kotlinX")
            }
            dependencies {
                implementation(libraries.kotlinx.io.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libraries.kotlin.test)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("org.wasmium.wasm:wasmium-wasm-binary:unspecified")
                implementation(libraries.clikt)
            }
        }
    }
}
