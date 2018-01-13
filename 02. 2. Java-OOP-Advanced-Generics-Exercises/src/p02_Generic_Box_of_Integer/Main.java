package p02_Generic_Box_of_Integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStrings = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStrings; i++) {

            int input = Integer.parseInt(reader.readLine());

            Generic_Class_Box generic_class_box = new Generic_Class_Box(input);
            System.out.println(generic_class_box.toString());
        }
    }
}
