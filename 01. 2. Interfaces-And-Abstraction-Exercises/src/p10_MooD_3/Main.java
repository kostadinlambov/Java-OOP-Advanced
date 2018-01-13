package p10_MooD_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+\\|\\s+");

        String userName = tokens[0];
        String characterType = tokens[1];

        int level = Integer.parseInt(tokens[3]);

        GameObjectInt gameObjectInt = null;
        if (characterType.equalsIgnoreCase("Archangel")) {
            int specialPoints = Integer.parseInt(tokens[2]);
            gameObjectInt = new Archangel(userName, level, specialPoints);


        } else {
            double specialPoints = Double.parseDouble(tokens[2]);
            gameObjectInt = new Demon(userName, level, specialPoints);
        }

        System.out.println(gameObjectInt.toString());
    }
}
