/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package png.chunk;

import java.nio.ByteBuffer;
import java.util.Arrays;

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

    //toString method for IDATChunk class
	public String toString() {
		return "IDATChunk [data=" + Arrays.toString(data) + ", bytes()=" + Arrays.toString(bytes()) + ", size()="
				+ size() + ", getType()=" + getType() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
