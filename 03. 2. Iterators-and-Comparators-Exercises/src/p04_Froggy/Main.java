package p04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lake<Integer> lake = new LakeImpl<>();
        while(true){

            Integer[] numbers = Arrays.stream(reader.readLine()
                    .split("[\\s+,]"))
                    .filter(x -> !x.equals(""))
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);

            lake.addElements(numbers);

            String secondInputLine = reader.readLine();

            if("End".equalsIgnoreCase(secondInputLine)){
                break;
            }
        }

        lake.sortElements();
        lake.print();
    }
}
