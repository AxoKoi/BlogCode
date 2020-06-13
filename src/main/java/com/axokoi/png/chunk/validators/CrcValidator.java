package com.axokoi.png.chunk.validators;

import com.axokoi.png.chunk.Chunk;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;

final class CrcValidator {

    private CrcValidator() {
        throw new UnsupportedOperationException("CrcValidator shouldn't be instantiated");
    }

    static boolean validate(Chunk chunk) {

        long crcAsLong = getCrcAsLong(chunk);

        byte[] data = chunk.getDataToVerify();
        CRC32 crc32 = new CRC32();
        crc32.update(data);

        return crc32.getValue() == crcAsLong;
    }


    private static long getCrcAsLong(Chunk chunk) {
        byte[] crc = chunk.getCRC();
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(0);
        buffer.put(crc);
        buffer.flip();
        return buffer.getLong();
    }
}
