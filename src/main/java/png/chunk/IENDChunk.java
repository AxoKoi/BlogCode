package png.chunk;

import java.nio.ByteBuffer;

public class IENDChunk extends Chunk {
    IENDChunk(ByteBuffer buffer) {
        super(buffer);
    }
}
