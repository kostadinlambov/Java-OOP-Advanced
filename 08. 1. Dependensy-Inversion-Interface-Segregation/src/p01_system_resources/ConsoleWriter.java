package p01_system_resources;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
