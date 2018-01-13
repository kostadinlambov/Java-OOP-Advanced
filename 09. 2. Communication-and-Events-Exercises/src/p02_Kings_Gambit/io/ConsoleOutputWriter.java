package p02_Kings_Gambit.io;

import p02_Kings_Gambit.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter{
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
