package png.chunk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public abstract class Chunk {
    static final int DATA_LENGTH_SIZE = 0x04;
    static final int TYPE_SIZE = 0x04;
    private static final int CRC_SIZE = 0x04;

    private final int dataLength;
    private final byte[] rawType = new byte[TYPE_SIZE];
    final byte[] data;
    private final byte[] crc = new byte[CRC_SIZE];
    private final AllowedChunkTypes type;

    Chunk(ByteBuffer buffer) {
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

        buffer.get(rawType, 0, TYPE_SIZE);

        this.type = AllowedChunkTypes.fromBytes(rawType)
                .orElseThrow(() -> new IllegalArgumentException("Unsupported chunk type:" + Arrays.toString(rawType)));

        data = new byte[dataLength];
        buffer.get(data, 0, dataLength);
        buffer.get(crc, 0, CRC_SIZE);
    }

    public byte[] bytes() {
        ByteBuffer buffer = ByteBuffer.allocate(DATA_LENGTH_SIZE + TYPE_SIZE + dataLength + CRC_SIZE);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(dataLength);
        buffer.put(rawType);
        buffer.put(data);
        buffer.put(crc);
        return buffer.array();
    }

    public AllowedChunkTypes getType() {
        return type;
    }
}
