package png;

import org.apache.commons.codec.DecoderException;
import org.junit.Assert;
import org.junit.Test;

import org.apache.commons.codec.binary.Hex;
import png.chunk.Chunk;

public class ChunkTest {

    @Test
    public void parse() throws DecoderException {
        byte[] rawChunk = Hex.decodeHex("0000000D4948445200000500000004C70806000000B27EDA4F");
        Chunk parsedChunk = Chunk.parse(rawChunk);

        Assert.assertArrayEquals(rawChunk,parsedChunk.bytes());
    }
}
