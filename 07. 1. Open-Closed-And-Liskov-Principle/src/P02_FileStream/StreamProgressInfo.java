package P02_FileStream;

public class StreamProgressInfo {
    private Streamable file;

    public StreamProgressInfo(Streamable file) {
        this.file = file;
    }

    public int calculateCurrentPercent() {
        return (this.file.getBytesSent() * 100) / this.file.getLength();
    }

    public static void main(String[] args) {
        File f = new File(10, 20);
        Music m = new Music(5, 2);
        Streamable s = new Music(15, 2);

        StreamProgressInfo a = new StreamProgressInfo(f);
        StreamProgressInfo b = new StreamProgressInfo(m);
        StreamProgressInfo c = new StreamProgressInfo(s);
        System.out.println(a.calculateCurrentPercent());
        System.out.println(b.calculateCurrentPercent());
        System.out.println(c.calculateCurrentPercent());
    }
}
