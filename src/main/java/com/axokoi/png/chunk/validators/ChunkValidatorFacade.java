/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package com.axokoi.png.chunk.validators;

import png.chunk.Chunk;

public final class ChunkValidatorFacade {

    private ChunkValidatorFacade(){
        throw new UnsupportedOperationException("ChunkValidatorFacade shouldn't be instantiated");
    }

    public static boolean validate(Chunk chunk) {
        switch (chunk.getType()) {
            case IHDR:
                return IHDRValidator.validate(chunk);
            case PLTE:
            case IDAT:
            case IEND:
            case cHRM:
            case gAMA:
            case iCCP:
            case sBIT:
            case sRGB:
            case bKGD:
            case hIST:
            case tRNS:
            case pHYs:
            case sPLT:
            case tIME:
            case iTXt:
            case tEXt:
            case zTXT:
            default:
                return true;
        }

    }
}
