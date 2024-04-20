@file:Suppress("UnstableApiUsage")

import build.gradle.api.includeModule
import java.net.URI

pluginManagement {
    includeBuild("build-settings-logic")
    includeBuild("build-logic")
}

plugins {
    id("build-settings-default")
}

dependencyResolutionManagement {
    versionCatalogs {
        create("buildCatalog") {
            from(files("./gradle/catalogs/buildCatalog.versions.toml"))
        }
    }
}

rootProject.name = "wasmium-toolkit"

includeBuild("../wasmium-wasm-binary")

includeModule("wasmium-toolkit")
