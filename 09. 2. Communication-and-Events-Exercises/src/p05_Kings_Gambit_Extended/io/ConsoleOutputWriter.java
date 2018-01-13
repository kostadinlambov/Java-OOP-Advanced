package p05_Kings_Gambit_Extended.io;

import p05_Kings_Gambit_Extended.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
