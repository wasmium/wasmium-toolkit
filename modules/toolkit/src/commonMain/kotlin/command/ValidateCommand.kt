package org.wasmium.toolkit.command

import java.io.FileInputStream
import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import org.wasmium.wasm.binary.SourceBinaryReader
import org.wasmium.wasm.binary.WasmBinaryReader
import org.wasmium.wasm.binary.reader.ModuleReader
import org.wasmium.wasm.binary.reader.ReaderOptions
import org.wasmium.wasm.binary.validator.ModuleValidator
import org.wasmium.wasm.binary.validator.ValidatorOptions

public class ValidateCommand : CliktCommand(name = "validate") {
    public val file: String by argument()

    override fun run() {
        val path = Path("pathString")
        FileInputStream(file).use {
            val source = WasmBinaryReader(SourceBinaryReader(SystemFileSystem.source(path).buffered().buffered()))

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
