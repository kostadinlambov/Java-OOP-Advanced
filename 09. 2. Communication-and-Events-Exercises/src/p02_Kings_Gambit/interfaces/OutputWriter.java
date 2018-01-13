package p02_Kings_Gambit.interfaces;

public interface OutputWriter {
    void writeLine(String output);

    void writeLine(String format, Object... params);
}
