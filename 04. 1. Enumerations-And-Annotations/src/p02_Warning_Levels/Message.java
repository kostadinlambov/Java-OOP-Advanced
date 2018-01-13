package p02_Warning_Levels;

public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
