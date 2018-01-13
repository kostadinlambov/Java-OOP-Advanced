package p05_Generic_Count_Method_Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringList = new ArrayList<>();

        int numberOfStrings = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStrings; i++) {

            String input = reader.readLine();
            stringList.add(input);
        }

        String elementToCompare = reader.readLine();

        int count = BoxClass.countMethod(stringList, elementToCompare);

        System.out.println(count);
    }
}
