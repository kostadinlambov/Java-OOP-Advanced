package p03_Coffee_Machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while(true){

            String[] line = reader.readLine().split("\\s+");


            if("end".equalsIgnoreCase(line[0])){
                break;
            }else if( line.length == 1){
                coffeeMachine.insertCoin(line[0]);
            }else{
                coffeeMachine.buyCoffee(line[0], line[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
