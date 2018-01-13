package p08_Custom_List_Sorter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomList<>();


        while (true) {

            String[] tokens = reader.readLine().split("\\s+");
            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String command = tokens[0];

            switch (command) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    int count = customList.countGreaterThan(tokens[1]);
                    System.out.println(count);
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    customList.sort();
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
            }
        }
    }
}
