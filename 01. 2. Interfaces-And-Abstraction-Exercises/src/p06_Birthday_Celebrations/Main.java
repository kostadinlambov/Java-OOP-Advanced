package p06_Birthday_Celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthday> list = new ArrayList<>();

        while (true) {

            String[] tokens = reader.readLine().split("\\s+");

            if ("End".equalsIgnoreCase(tokens[0])) {
                break;
            }

            if (tokens[0].equalsIgnoreCase("Citizen")) {
                String birthday = tokens[4];

                Birthday citizen = new Citizen(birthday);
                list.add(citizen);
            } else if(tokens[0].equalsIgnoreCase("Pet")) {
                String birthday = tokens[2];

                Birthday pet = new Pet(birthday);
                list.add(pet);
            }
        }

        String yearOfBirthdayToPrint = reader.readLine();

        for (Birthday member : list) {
            if (member.checkYearOfBirth(yearOfBirthdayToPrint)) {
                System.out.println(member.getBirthday());
            }
        }
    }
}
