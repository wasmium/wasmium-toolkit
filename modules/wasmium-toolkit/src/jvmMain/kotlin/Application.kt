package org.wasmium.wasm.toolkit

import java.io.File
import com.github.ajalt.clikt.core.subcommands
import org.wasmium.wasm.toolkit.command.ApplicationCommand
import org.wasmium.wasm.toolkit.command.ValidateCommand
import org.wasmium.wasm.toolkit.command.VerifyCommand

public fun main(args: Array<String>): Unit {
    val file = File("../../../wasmium-wasm/repository/doom.wasm")

    val args = arrayOf("validate", file.canonicalPath)

    ApplicationCommand().subcommands(
        VerifyCommand(),
        ValidateCommand(),
    ).main(args)
}
