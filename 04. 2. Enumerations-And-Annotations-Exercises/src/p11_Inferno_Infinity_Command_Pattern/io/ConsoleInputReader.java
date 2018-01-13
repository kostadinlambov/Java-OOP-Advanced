package p11_Inferno_Infinity_Command_Pattern.io;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public class ConsoleInputReader implements InputReader {
    private BufferedReader reader;

    public ConsoleInputReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = this.reader.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }
}
