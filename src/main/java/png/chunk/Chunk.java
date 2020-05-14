package png.chunk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Chunk {
    private static final int DATA_LENGTH_SIZE = 0x04;
    private static final int TYPE_SIZE = 0x04;
    private static final int CRC_SIZE = 0x04;

    private final int dataLength;
    private final byte[] type = new byte[TYPE_SIZE];
    private final byte[] data;
    private final byte[] crc = new byte[CRC_SIZE];

    private Chunk(ByteBuffer buffer) {
        if (buffer.order() != ByteOrder.BIG_ENDIAN) {
            throw new IllegalArgumentException("Order for chunk should be:" + ByteOrder.BIG_ENDIAN + " but was " + buffer.order());
        }
        if (buffer.remaining() < DATA_LENGTH_SIZE + TYPE_SIZE + CRC_SIZE) {
            throw new IllegalArgumentException("Not enough remaining data on buffer. Expected at least " + DATA_LENGTH_SIZE + TYPE_SIZE + CRC_SIZE
                    + "but was " + buffer.remaining());
        }

        this.dataLength = buffer.getInt();
        if (buffer.remaining() < TYPE_SIZE + dataLength + CRC_SIZE) {
            throw new IllegalArgumentException("Not enough remaining data on buffer. Expected at least " + TYPE_SIZE + dataLength + CRC_SIZE
                    + " but was " + buffer.remaining());
        }

        buffer.get(type, 0, TYPE_SIZE);
        data = new byte[dataLength];
        buffer.get(data, 0, dataLength);
        buffer.get(crc, 0, CRC_SIZE);
    }

    public static Chunk parse(byte[] rawChunk) {
        return parse(ByteBuffer.wrap(rawChunk));
    }

    public static Chunk parse(ByteBuffer buffer) {
        return new Chunk(buffer);
    }

    public byte[] bytes() {
        ByteBuffer buffer = ByteBuffer.allocate(DATA_LENGTH_SIZE + TYPE_SIZE + dataLength + CRC_SIZE);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(dataLength);
        buffer.put(type);
        buffer.put(data);
        buffer.put(crc);
        return buffer.array();
    }

}
