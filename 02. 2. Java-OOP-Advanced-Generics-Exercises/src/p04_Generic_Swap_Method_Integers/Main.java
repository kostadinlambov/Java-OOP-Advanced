package p04_Generic_Swap_Method_Integers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integerList = new ArrayList<>();

        int numberOfStrings = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStrings; i++) {

            int input = Integer.parseInt(reader.readLine());
            integerList.add(input);
        }

        int[] indexes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        swapStrings(integerList, firstIndex, secondIndex);
    }

    public static <T> void swapStrings(List<T> inputList, int firstIndex, int secondIndex) {

        T tempelement = inputList.get(firstIndex);
        T secondElement = inputList.get(secondIndex);

        inputList.remove(firstIndex);
        inputList.add(firstIndex, secondElement);
        inputList.remove(secondIndex);
        inputList.add(secondIndex, tempelement);

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println(inputList.get(i).getClass().getCanonicalName() + ": " + inputList.get(i));
        }
    }
}
