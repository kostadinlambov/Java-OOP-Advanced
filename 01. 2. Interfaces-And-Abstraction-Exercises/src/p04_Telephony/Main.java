package p04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersToCall = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");

        Callable callOtherPhones = new Smartphone();

        for (int i = 0; i < numbersToCall.length; i++) {
            callOtherPhones.callPhones(numbersToCall[i]);
        }

        Browsable browse = new Smartphone();

        for (int i = 0; i < urls.length; i++) {
            browse.browseInWeb(urls[i]);
        }
    }
}
