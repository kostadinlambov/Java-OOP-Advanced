package p05_Kings_Gambit_Extended.interfaces;

public interface OutputWriter {
    void writeLine(String output);

    void writeLine(String format, Object... params);
}
