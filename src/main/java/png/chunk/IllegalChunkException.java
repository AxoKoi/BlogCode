package png.chunk;

public class IllegalChunkException extends Exception {

    public IllegalChunkException(String message, Chunk chunk) {
        super(message + "\n" + chunk);
    }
}
