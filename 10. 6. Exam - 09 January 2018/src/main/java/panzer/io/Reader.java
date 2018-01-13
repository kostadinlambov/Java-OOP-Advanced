package panzer.io;


import panzer.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader implements InputReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
           return null;
        }
    }
}
