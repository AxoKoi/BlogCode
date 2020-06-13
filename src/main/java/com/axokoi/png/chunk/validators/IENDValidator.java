package com.axokoi.png.chunk.validators;

import com.axokoi.png.chunk.Chunk;

final class IENDValidator {

    public IENDValidator() {
        throw new UnsupportedOperationException("Validator shouldn't be instantiated");
    }

    static boolean validate(Chunk chunk) {
        //No semantic validation to be performed.
        return true;
    }
}
