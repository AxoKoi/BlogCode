/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
 */
package png.chunk;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class IENDChunk extends Chunk {
	IENDChunk(ByteBuffer buffer) {
		super(buffer);
	}

	//toString method for IENDChunk Class
	public String toString() {
		return "IENDChunk [data=" + Arrays.toString(data) + ", bytes()=" + Arrays.toString(bytes()) + ", size()="
				+ size() + ", getType()=" + getType() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
