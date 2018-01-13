package p10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Tuple> tupleList = new ArrayList<>();

        String[] firstLineTokens = reader.readLine().split("\\s+");

        String firstName = firstLineTokens[0];
        String lastName = firstLineTokens[1];
        String fullName = firstName + " " + lastName;
        String address = firstLineTokens[2];

        Tuple<String, String> tuple1 = new TupleImpl<>(fullName,address);
        tupleList.add(tuple1);

        String[] secondLineTokens = reader.readLine().split("\\s+");

        String name = secondLineTokens[0];
        Integer amountOfBeer = Integer.parseInt(secondLineTokens[1]);

        Tuple<String, Integer> tuple2 = new TupleImpl<>(name, amountOfBeer);
        tupleList.add(tuple2);

        String[] thirdLineTokens = reader.readLine().split("\\s+");

        Integer integerNumber = Integer.parseInt(thirdLineTokens[0]);
        Double doubleNumber = Double.parseDouble(thirdLineTokens[1]);

        Tuple<Integer, Double> tuple3 = new TupleImpl<>(integerNumber, doubleNumber);
        tupleList.add(tuple3);

        for (Tuple tuple : tupleList) {
            System.out.println(tuple);
        }
    }
}
