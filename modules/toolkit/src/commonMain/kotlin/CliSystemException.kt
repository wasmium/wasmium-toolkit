package org.wasmium.toolkit

public class CliSystemException(
    public override val cause: Throwable,
    public override val exitCode: Int = 1,
): CliException("An unexpected error has occurred.", exitCode) {
}
