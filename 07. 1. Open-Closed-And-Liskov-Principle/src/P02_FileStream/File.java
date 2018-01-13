package P02_FileStream;

public class File implements Streamable{

    private String name;
    private int length;
    private int bytesSent;

    public File(int length, int bytesSent) {
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
