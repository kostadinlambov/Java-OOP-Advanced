package p02_Kings_Gambit.io;

import p02_Kings_Gambit.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputreader implements InputReader {
    private BufferedReader reader;

    public ConsoleInputreader(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public String readLine() {
        String line = null;
        try{
            line = this.reader.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }
}
