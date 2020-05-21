package png.chunk;

import java.nio.ByteBuffer;


/**
 * This class is a development class. It will be removed
 * after the all the concrete chunks are implemented.
 */
@Deprecated
public class DefaultChunk extends Chunk {
    DefaultChunk(ByteBuffer buffer) {
        super(buffer);
    }
}
