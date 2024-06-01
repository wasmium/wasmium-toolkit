package org.wasmium.wasm.toolkit

import com.github.ajalt.clikt.core.subcommands
import org.wasmium.wasm.toolkit.command.ApplicationCommand
import org.wasmium.wasm.toolkit.command.ValidateCommand
import org.wasmium.wasm.toolkit.command.VerifyCommand

public fun main(args: Array<String>): Unit {
    ApplicationCommand().subcommands(
        VerifyCommand(),
        ValidateCommand(),
    ).main(args)
}
