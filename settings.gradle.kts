@file:Suppress("UnstableApiUsage")

import org.gradle.api.initialization.includeModule


pluginManagement {
    includeBuild("build-settings-logic")
    includeBuild("build-logic")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("build-settings-default")
}

rootProject.name = "wasmium-toolkit"

includeModule("toolkit")
