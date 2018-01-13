package p02_Warning_Levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Importance inputImportance = Importance.valueOf(reader.readLine().toUpperCase());

        Logger logger = new Logger(inputImportance);

        while (true) {
            String[] line = reader.readLine().split(":\\s+");
            if ("End".equalsIgnoreCase(line[0])) {
                break;
            }

            logger.receiveMessage(Importance.valueOf(line[0].toUpperCase()), line[1]);
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
