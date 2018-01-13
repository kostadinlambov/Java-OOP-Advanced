package p06_Generic_Count_Method_Doubles;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> doubleList = new ArrayList<>();

        int numberOfStrings = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStrings; i++) {

            double input = Double.parseDouble(reader.readLine());
            doubleList.add(input);
        }

        double elementToCompare = Double.parseDouble(reader.readLine());

        int count = BoxClass.countMethod(doubleList, elementToCompare);

        System.out.println(count);
    }
}
