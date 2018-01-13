package P02_FileStream;

public class Music implements Streamable{

    private String artist;
    private String album;
    private int length;
    private int bytesSent;

    public Music(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getBytesSent() {
        return bytesSent;
    }
}
