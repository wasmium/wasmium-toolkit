package org.wasmium.toolkit

public open class CliException(
    public override val message: String,
    public open val exitCode: Int = 1,
): RuntimeException(message)
