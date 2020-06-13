package com.axokoi.png.chunk.validators;

import com.axokoi.png.chunk.Chunk;

final class TRNSValidator {

    private TRNSValidator() {
        throw new UnsupportedOperationException("Validator shouldn't be instantiated");
    }

    static boolean validate(Chunk chunk) {
        return true;
    }
}
