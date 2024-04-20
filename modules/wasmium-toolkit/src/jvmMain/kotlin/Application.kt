package org.wasmium.wasm.toolkit

import com.github.ajalt.clikt.core.subcommands
import commands.VerifyCommand
import org.wasmium.wasm.toolkit.commands.ApplicationCommand
import org.wasmium.wasm.toolkit.commands.ValidateCommand

public fun main(args: Array<String>): Unit {

    ApplicationCommand().subcommands(
        VerifyCommand(),
        ValidateCommand(),
    ).main(args)
}
