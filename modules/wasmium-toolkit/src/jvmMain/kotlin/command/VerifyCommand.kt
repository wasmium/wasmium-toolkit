package org.wasmium.wasm.toolkit.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import kotlinx.io.asSource
import kotlinx.io.buffered
import org.wasmium.wasm.binary.SourceBinaryReader
import org.wasmium.wasm.binary.WasmBinaryReader
import org.wasmium.wasm.binary.reader.ModuleReader
import org.wasmium.wasm.binary.reader.ReaderOptions
import org.wasmium.wasm.binary.verifier.ModuleVerifier
import org.wasmium.wasm.binary.verifier.VerifierOptions
import java.io.File
import java.io.FileInputStream

public class VerifyCommand : CliktCommand(name = "verify", help = "Verify a wasm module") {
    public val file: File by argument().file(mustBeReadable = true)

    override fun run() {
        FileInputStream(file).use {
            val source = WasmBinaryReader(SourceBinaryReader(it.asSource().buffered()))

            val readerOptions = ReaderOptions {
                debugNames(true)
                skipSections(listOf())

                features {
                    enableAll()
                }
            }

            val verifierOptions = VerifierOptions {
                features {
                    enableAll()
                }
            }

            ModuleReader(readerOptions).readModule(source, ModuleVerifier(options = verifierOptions))

            println("Wasm module is verified")
        }
    }
}
