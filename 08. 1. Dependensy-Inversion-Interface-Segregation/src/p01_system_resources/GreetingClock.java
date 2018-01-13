package p01_system_resources;


public class GreetingClock {

    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    public void greeting() {
        if (time.getHour() < 12) {
           writer.write("Good morning...");
        } else if (time.getHour() < 18) {
            writer.write("Good afternoon...");
        } else {
            writer.write("Good evening...");
        }
    }
}
