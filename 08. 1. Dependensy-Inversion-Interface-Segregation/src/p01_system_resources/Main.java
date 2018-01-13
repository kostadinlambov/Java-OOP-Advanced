package p01_system_resources;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        TimeProvider time = new TestTime();
        TimeProvider time2 = new AnotherTime();

        Writer writer = new ConsoleWriter();

        GreetingClock greetingClock = new GreetingClock(time, writer);
        GreetingClock greetingClock2 = new GreetingClock(time2, writer);

        greetingClock.greeting();
        greetingClock2.greeting();
    }
}
