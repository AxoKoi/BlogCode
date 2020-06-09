/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package com.axokoi.util;

public class EndiannessUtil {

    private EndiannessUtil() {
        throw new UnsupportedOperationException("Utility class shouldn't be instantiated");
    }

    public static byte[] toByteArray(final int number) {
        return new byte[]{
                (byte) ((number >> 24) & 0xff),
                (byte) ((number >> 16) & 0xff),
                (byte) ((number >> 8) & 0xff),
                (byte) ((number) & 0xff)};
    }

    public static byte[] reverseIntegerEndianness(byte[] number) {
        int size = number.length;
        if (size != 4) {
            throw new IllegalArgumentException("Byte array length should be 4  (32bits) but was" +
                    size);
        }

        byte[] reversedEndianness = new byte[number.length];
        for (int i = 0; i < size; i++) {
            reversedEndianness[i] = number[size - i - 1];
        }
        return reversedEndianness;
    }


}
