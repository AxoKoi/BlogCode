package png.chunk;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChunkFactoryTest {

    @Test
    public void parse() throws DecoderException {
        byte[] rawChunk = Hex.decodeHex("0000000D4948445200000500000004C70806000000B27EDA4F");
        Chunk chunk = ChunkFactory.parse(ByteBuffer.wrap(rawChunk));

        assertEquals(AllowedChunkTypes.IHDR, chunk.getType());
        assertTrue(chunk instanceof IHDRChunk);
        Assert.assertArrayEquals(rawChunk, chunk.bytes());

        byte[] expectedWidth = {0x00, 0x00, 0x05, 0x00};
        byte[] expectedHeight = {0x00, 0x00, 0x04, (byte) 0xC7};

        IHDRChunk headerChunk = (IHDRChunk) chunk;
        Assert.assertArrayEquals(expectedWidth, headerChunk.getWidth());
        Assert.assertArrayEquals(expectedHeight, headerChunk.getHeight());
        assertEquals(0x08, headerChunk.getBitDepth());
        assertEquals(0x06, headerChunk.getColourType());
        assertEquals(0x00, headerChunk.getCompressionMethod());
        assertEquals(0x00, headerChunk.getFilterMethod());
        assertEquals(0x00, headerChunk.getInterlaceMethod());

    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_wrongChunkID() throws DecoderException {
        byte[] rawChunk = Hex.decodeHex("0000000D9999999900000500000004C70806000000B27EDA4F");
        ChunkFactory.parse(ByteBuffer.wrap(rawChunk));
    }
}
