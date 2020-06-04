/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package png.chunk;

import java.nio.ByteBuffer;

public class IENDChunk extends Chunk {
    IENDChunk(ByteBuffer buffer) {
        super(buffer);
    }
}
