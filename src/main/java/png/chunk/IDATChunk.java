package png.chunk;

import java.nio.ByteBuffer;

/**
 * The four-byte chunk type field contains the decimal values
 *
 * 73 68 65 84
 * The IDAT chunk contains the actual image data which is the output stream of the compression algorithm.
 */
public class IDATChunk extends Chunk {
    IDATChunk(ByteBuffer buffer) {
        super(buffer);
    }
}
