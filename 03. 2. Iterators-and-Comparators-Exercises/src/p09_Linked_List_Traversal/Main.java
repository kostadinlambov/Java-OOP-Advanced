package p09_Linked_List_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        MyLinkedList list = new MyLinkedListImpl();
        int number = Integer.parseInt(scan.readLine());

        for (int i = 0; i < number; i++) {
            String[] input = scan.readLine().split("\\s+");
            if (input[0].equals("Add")) {
                list.addLast(Integer.valueOf(input[1]));
            } else {
                list.removeFirstOccurrenceOfItem(Integer.valueOf(input[1]));
            }
        }

        System.out.println(list.getSize());
        System.out.println(list.toString().replace("[","").replace("]","").replace(",",""));
    }
}
