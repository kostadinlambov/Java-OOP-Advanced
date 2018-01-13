package p03_Stack_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> integerStack = new StackImpl<>();

        while(true){
            String[] tokens = Arrays.stream(reader.readLine().split("[\\s+,]"))
                    .filter(x -> !x.equals(""))
                    .toArray(String[]::new);

            if("End".equalsIgnoreCase(tokens[0])){
                break;
            }

            String command = tokens[0];

            switch (command){
                case "Push":
                    Integer[] data = Arrays.stream(tokens).skip(1).map(Integer::parseInt).toArray(Integer[]::new);
                    integerStack.push(data);
                    break;
                case "Pop":
                    try{
                        integerStack.pop();
                    }catch(UnsupportedOperationException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        for (int i = 0; i < 2; i++) {
            integerStack.forEach(System.out::println);

        }
    }
}
