package png.chunk;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

public enum AllowedChunkTypes {

    IHDR("IHDR"),
    PLTE("PLTE"),
    IDAT("IDAT"),
    IEND("IEND"),
    cHRM("cHRM"),
    gAMA("gAMA"),
    iCCP("iCCP"),
    sBIT("sBIT"),
    sRGB("sRGB"),
    bKGD("bKGD"),
    hIST("hIST"),
    tRNS("tRNS"),
    pHYs("pHYs"),
    sPLT("sPLT"),
    tIME("tIME"),
    iTXt("iTXt"),
    tEXt("tEXt"),
    zTXT("zTXT");


    private final String name;

    AllowedChunkTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte[] bytes() {
        return this.name.getBytes(StandardCharsets.US_ASCII);
    }

    public Optional<AllowedChunkTypes> fromName(String name) {
        return Arrays.stream(AllowedChunkTypes.values())
                .filter(x -> x.getName().equals(name))
                .findFirst();
    }
}