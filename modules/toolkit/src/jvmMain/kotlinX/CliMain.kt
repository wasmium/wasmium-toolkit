package org.wasmium.toolkit

import java.io.PrintStream
import kotlin.system.exitProcess

private fun printError(cause: Throwable, stream: PrintStream) {
    val message = cause.toString()
    stream.print(message)

    if (!message.endsWith('\n')) stream.println()
}

public fun runCli(block: () -> Unit) {
    try {
        block()
    } catch (clie: CliException) {
        printError(clie, if (clie.exitCode == 0) System.out else System.err)
        exitProcess(clie.exitCode)
    } catch (se: CliSystemException) {
        printError(CliSystemException(se), System.err)
        exitProcess(1)
    }
}
