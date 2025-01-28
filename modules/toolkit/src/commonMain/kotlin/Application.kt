package org.wasmium.toolkit

import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands
import org.wasmium.toolkit.command.RootCommand
import org.wasmium.toolkit.command.ValidateCommand
import org.wasmium.toolkit.command.VerifyCommand

public fun main(args: Array<String>): Unit {
    RootCommand("wasmium", "0.1.0")
        .subcommands(
            VerifyCommand(),
            ValidateCommand(),
        )
        .main(args)
}
