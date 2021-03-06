/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package com.axokoi.misc;


import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class TaggedStringTest {

    @Test
    public void TaggedString_uppercase() throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.allocate(0x10);

        buffer.putInt(TaggedString.AllowedTag.UPPERCASE.getValue());
        buffer.put("TeSt".getBytes());
        buffer.flip();

        TaggedString taggedString = new TaggedString(buffer.array());

        Assert.assertEquals("TEST\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",taggedString.getValue());

    }

    @Test
    public void TaggedString_lowercase() throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.allocate(0x10);

        buffer.putInt(TaggedString.AllowedTag.LOWERCASE.getValue());
        buffer.put("TeSt".getBytes());
        buffer.flip();

        TaggedString taggedString = new TaggedString(buffer.array());

        Assert.assertEquals("test\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",taggedString.getValue());

    }
}
