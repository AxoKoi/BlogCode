package com.axokoi.misc;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class TaggedString {
    private static final int TAG_SIZE = 4;
    private static final int DATA_SIZE = 12;

    private final String value;

    enum AllowedTag {
        UPPERCASE(0x10000001),
        LOWERCASE(0x00000001);

        final int value;

        AllowedTag(int value) {
            this.value = value;
        }

        public static AllowedTag fromInt(int value) {
            for (AllowedTag tag : AllowedTag.values()) {
                if (tag.value == value) {
                    return tag;
                }
            }
            throw new IllegalArgumentException("Illegal tag " + Integer.toHexString(value));
        }

        public int getValue() {
            return value;
        }
    }

    public TaggedString(byte[] rawTaggedString) throws UnsupportedEncodingException {

        byte[] rawTag = new byte[TAG_SIZE];
        byte[] rawData = new byte[DATA_SIZE];

        System.arraycopy(rawTaggedString, 0, rawTag, 0, TAG_SIZE);
        System.arraycopy(rawTaggedString, TAG_SIZE, rawData, 0, DATA_SIZE);

        String rawValue = new String(rawData, "UTF-8");

        int tagAsInt = ByteBuffer.wrap(rawTag).getInt();
        AllowedTag tag = AllowedTag.fromInt(tagAsInt);
        switch (tag) {
            case UPPERCASE:
                this.value = rawValue.toUpperCase();
                break;

            case LOWERCASE:
                this.value = rawValue.toLowerCase();
                break;
            default:
                throw new IllegalArgumentException("Unsupported Tag" + tag);
        }
    }

    public String getValue() {
        return value;
    }
}
