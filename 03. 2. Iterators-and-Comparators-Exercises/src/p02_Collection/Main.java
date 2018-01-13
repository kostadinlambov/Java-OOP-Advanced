package p02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIteratorImpl listyIterator = null;

        while(true){

            String[] tokens = reader.readLine().split("\\s+");

            if("End".equalsIgnoreCase(tokens[0])){
                break;
            }

            String command = tokens[0];

            switch (command){
                case "Create":
                    listyIterator =  new ListyIteratorImpl(createElements(tokens));
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    try {
                        listyIterator.printAll();
                    }catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }
    }

    private static String[] createElements(String[] arr) {
        String[] elementsArr = new String[arr.length-1];

        for (int i = 0; i < elementsArr.length; i++) {
            elementsArr[i] = arr[i+1];
        }
        return elementsArr;
    }
}
