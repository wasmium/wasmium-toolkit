package org.wasmium.wasm.toolkit

import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.versionOption
import org.wasmium.wasm.toolkit.command.ValidateCommand
import org.wasmium.wasm.toolkit.command.VerifyCommand

public fun main(args: Array<String>) {
    NoOpCliktCommand()
        .subcommands(
            VerifyCommand(),
            ValidateCommand(),
        )
        .versionOption("0.1.0")
        .main(args)
}
