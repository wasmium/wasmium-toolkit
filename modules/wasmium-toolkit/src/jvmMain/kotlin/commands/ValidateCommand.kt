package org.wasmium.wasm.toolkit.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import kotlinx.io.asSource
import kotlinx.io.buffered
import org.wasmium.wasm.binary.SourceBinaryReader
import org.wasmium.wasm.binary.WasmBinaryReader
import org.wasmium.wasm.binary.reader.ModuleReader
import org.wasmium.wasm.binary.reader.ReaderOptions
import org.wasmium.wasm.binary.validator.ModuleValidator
import org.wasmium.wasm.binary.validator.ValidatorOptions
import java.io.File
import java.io.FileInputStream

public class ValidateCommand : CliktCommand(name = "validate", help = "Validate a wasm module") {
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

            val validatorOptions = ValidatorOptions {
                features {
                    enableAll()
                }
            }

            ModuleReader(readerOptions).readModule(source, ModuleValidator(options = validatorOptions))

            println("Wasm module is validated")
        }
    }
}
