package p11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Threeuple> threeupleList = new ArrayList<>();

        String[] firstLineTokens = reader.readLine().split("\\s+");

        String firstName = firstLineTokens[0];
        String lastName = firstLineTokens[1];
        String fullName = firstName + " " + lastName;
        String address = firstLineTokens[2];
        String town = firstLineTokens[3];

        Threeuple<String, String, String> threeuple1 = new ThreeupleImpl<>(fullName, address, town);
        threeupleList.add(threeuple1);

        String[] secondLineTokens = reader.readLine().split("\\s+");

        String name = secondLineTokens[0];
        Integer amountOfBeer = Integer.parseInt(secondLineTokens[1]);
        boolean drunkOrNot = false;
        if (secondLineTokens[2].equals("drunk")) {
            drunkOrNot = true;
        }

        Threeuple<String, Integer, Boolean> threeuple2 = new ThreeupleImpl<>(name, amountOfBeer, drunkOrNot);
        threeupleList.add(threeuple2);

        String[] thirdLineTokens = reader.readLine().split("\\s+");

        String name2 = thirdLineTokens[0];
        Double accountBalance = Double.parseDouble(thirdLineTokens[1]);
        String bankName = thirdLineTokens[2];

        Threeuple<String, Double, String> threeuple3 = new ThreeupleImpl<>(name2, accountBalance, bankName);
        threeupleList.add(threeuple3);

        for (Threeuple threeuple : threeupleList) {
            System.out.println(threeuple);
        }
    }
}
