package org.wasmium.toolkit.command

import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.parameters.options.versionOption

public class RootCommand(name: String, version: String) : NoOpCliktCommand(
    name = name,
) {
    init {
        versionOption(version, names = setOf("-v", "--version"), message = { it })
    }
}
