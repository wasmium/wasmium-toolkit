plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

configurations.all {
    resolutionStrategy {
        failOnNonReproducibleResolution()
    }
}

dependencies {
    api(libraries.kotlin.gradle.plugin)
}

kotlin {
    explicitApi()

    compilerOptions {
        freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
    }

    sourceSets {
        main {
            kotlin {
                srcDirs("src/main/kotlinX")
            }
        }
    }
}

gradlePlugin {
    plugins {
        register("SettingsDefaultPlugin") {
            id = "build-settings-default"
            implementationClass = "build.gradle.plugins.settings.SettingsDefaultPlugin"
        }
    }
}

tasks {
    withType<ValidatePlugins>().configureEach {
        failOnWarning.set(true)
        enableStricterValidation.set(true)
    }
}
