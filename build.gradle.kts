plugins {
    alias(libraries.plugins.kotlinx.bcv)
    alias(libraries.plugins.detekt)

    id("build-project-default")
    id("build-wrapper-configurer")
    id("build-detekt-configurer")
}

description = "Root Project"

allprojects {
    group = "org.wasmium.wasm.toolkit"

    configurations.all {
        resolutionStrategy {
            failOnNonReproducibleResolution()
        }
    }
}

allprojects {
    group = "org.wasmium.wasm"

    configurations.configureEach {
        resolutionStrategy {
            failOnNonReproducibleResolution()
        }
    }
}

apiValidation {
    ignoredPackages.add("org.wasmium.wasm.internal")

    ignoredProjects.addAll(
        listOf(
            "bom",
            "version-catalog",
        )
    )
}

tasks {
    // Fix CodeQL workflow execution
    val testClasses by registering
}
