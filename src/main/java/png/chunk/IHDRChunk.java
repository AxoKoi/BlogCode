package png.chunk;

import java.nio.ByteBuffer;

public final class IHDRChunk extends Chunk {

    private final byte[] width;
    private final byte[] height;
    private final byte bitDepth;
    private final byte colourType;
    private final byte compressionMethod;
    private final byte filterMethod;
    private final byte interlaceMethod;

    IHDRChunk(ByteBuffer buffer) {
        super(buffer);
        ByteBuffer dataBuffer = ByteBuffer.allocate(data.length);
        dataBuffer.put(super.data);
        dataBuffer.flip();

        width = new byte[0x04];
        dataBuffer.get(width, 0, 0x04);

        height = new byte[0x04];
        dataBuffer.get(height, 0, 0x04);

        bitDepth = dataBuffer.get();
        colourType = dataBuffer.get();
        compressionMethod = dataBuffer.get();
        filterMethod = dataBuffer.get();
        interlaceMethod = dataBuffer.get();
    }

    public byte[] getWidth() {
        byte[] widthToReturn = new byte[0x04];
        System.arraycopy(width, 0, widthToReturn, 0, 0x04);
        return widthToReturn;
    }

    public byte[] getHeight() {
        byte[] heightToReturn = new byte[0x04];
        System.arraycopy(height, 0, heightToReturn, 0, 0x04);
        return heightToReturn;
    }

    public byte getBitDepth() {
        return bitDepth;
    }

    public byte getColourType() {
        return colourType;
    }

    public byte getCompressionMethod() {
        return compressionMethod;
    }

    public byte getFilterMethod() {
        return filterMethod;
    }

    public byte getInterlaceMethod() {
        return interlaceMethod;
    }
}
