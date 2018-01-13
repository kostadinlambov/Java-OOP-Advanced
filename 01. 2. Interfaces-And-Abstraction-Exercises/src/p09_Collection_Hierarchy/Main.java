package p09_Collection_Hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection<String> addCollection = new AddCollectionImpl<>();
        AddRemoveCollection<String> addRemoveCollection = new AddRemoveCollectionImpl<>();
        MyList<String> myList = new MyListImpl<>();

        String[] tokens = reader.readLine().split("\\s+");
        int countOfRemovedElements = Integer.parseInt(reader.readLine());

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (String token : tokens) {
            sb1.append(addCollection.add(token)).append(" ");
            sb2.append(addRemoveCollection.add(token)).append(" ");
            sb3.append(myList.add(token)).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());

        sb1.setLength(0);
        sb2.setLength(0);
        sb3.setLength(0);

        for (int i = 0; i < countOfRemovedElements; i++) {
            sb2.append(addRemoveCollection.remove()).append(" ");
            sb3.append(myList.remove()).append(" ");
        }

        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());
    }
}
