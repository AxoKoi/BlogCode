package util;

import org.junit.Assert;
import org.junit.Test;
import util.EndiannessUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class EndiannessUtilTest {

    @Test
    public void reverseIntegerEndianness() {

        byte[] rawInt = {(byte) 0xCA, (byte) 0xFE,0x01,0x02};
        byte[] expectedReversedRawInt ={0x02,0x01, (byte) 0xFE,(byte) 0xCA};

        Assert.assertArrayEquals(expectedReversedRawInt, EndiannessUtil.reverseIntegerEndianness(rawInt));

    }

    @Test
    public void bufferUsage() {
        int n1 = 0x01020304;
        int n2 = 0x05060708;
        int n3 = 0x090A0B0C;
        int n4 = 0x0D0E0F10;

        final byte[] expectedBigEndian = {0x01, 0x02, 0x03, 0x04,
                0x05, 0x06, 0x07, 0x08,
                0x09, 0x0A, 0x0B, 0x0C,
                0x0D, 0x0E, 0x0F, 0x10};

        ByteBuffer bufferBigEndian = ByteBuffer.allocate(16);
        bufferBigEndian.order(ByteOrder.BIG_ENDIAN);
        bufferBigEndian.putInt(n1).putInt(n2).putInt(n3).putInt(n4);
        Assert.assertArrayEquals(expectedBigEndian, bufferBigEndian.array());

        final byte[] expectedLittleEndian = {0x04, 0x03, 0x02, 0x01,
                0x08, 0x07, 0x06, 0x05,
                0x0C, 0x0B, 0x0A, 0x09,
                0x10, 0x0F, 0x0E, 0x0D};

        ByteBuffer bufferLittleEndian = ByteBuffer.allocate(16);
        bufferLittleEndian.order(ByteOrder.LITTLE_ENDIAN);
        bufferLittleEndian.putInt(n1).putInt(n2).putInt(n3).putInt(n4);

        Assert.assertArrayEquals(expectedLittleEndian, bufferLittleEndian.array());
    }

}
