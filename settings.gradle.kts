pluginManagement {
    includeBuild("build-settings-logic")
    includeBuild("build-logic")
}

plugins {
    id("build-settings-default")
    id("build-foojay")
}

rootProject.name = "wasmium-toolkit"

include(":modules:toolkit")

include("publishing:bom")
include("publishing:version-catalog")
