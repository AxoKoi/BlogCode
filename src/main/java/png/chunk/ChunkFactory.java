package png.chunk;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class ChunkFactory {

    private ChunkFactory() {
        throw new UnsupportedOperationException("Chunk Factory doesn't need to be instantiated");
    }

    public static Chunk parse(ByteBuffer buffer) {
        buffer.mark();
        buffer.position(Chunk.DATA_LENGTH_SIZE);

        byte[] rawType = new byte[Chunk.TYPE_SIZE];
        buffer.get(rawType, 0, Chunk.TYPE_SIZE);
        buffer.reset();

        AllowedChunkTypes type = AllowedChunkTypes.fromBytes(rawType)
                .orElseThrow(() -> new IllegalArgumentException("Unknown chunk type: " + Arrays.toString(rawType)));

        return createChunk(buffer, type);
    }

    private static Chunk createChunk(ByteBuffer buffer, AllowedChunkTypes type) {
        switch (type) {
            case IHDR:
                return new IHDRChunk(buffer);
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
                throw new UnsupportedOperationException("Chunk not yet supported.");

            default:
                throw new UnsupportedOperationException("Unsupported chunk to be created:" + type);
        }
    }

}
