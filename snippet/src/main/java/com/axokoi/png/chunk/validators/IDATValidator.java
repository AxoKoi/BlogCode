/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package com.axokoi.png.chunk.validators;

import com.axokoi.png.chunk.Chunk;

final class IDATValidator {
    private IDATValidator() {
        throw new UnsupportedOperationException("Validator shouldn't be instantiated");
    }

    static boolean validate(Chunk chunk) {
        //No semantic validation to be performed.
        return true;
    }

}
