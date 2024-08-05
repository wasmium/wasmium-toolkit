@file:Suppress("UnstableApiUsage")

import build.gradle.api.includeModule

pluginManagement {
    includeBuild("build-settings-logic")
    includeBuild("build-logic")
}

plugins {
    id("build-settings-default")
}

rootProject.name = "wasmium-toolkit"

includeBuild("../wasmium-wasm")

includeModule("wasmium-toolkit")
