package p07_Food_Shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> buyerMap = new HashMap<>();

        int numberOFPeople = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOFPeople; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            if(tokens.length == 4){
                Buyer buyer = new Citizen(tokens[0],tokens[1], tokens[2], tokens[2]);
                buyerMap.putIfAbsent(tokens[0], buyer);
            }else{
                Buyer buyer = new Rebel(tokens[0],Integer.parseInt(tokens[1]), tokens[2]);
                buyerMap.putIfAbsent(tokens[0], buyer);
            }
        }

        while(true){

            String name = reader.readLine();

            if("End".equalsIgnoreCase(name)){
                break;
            }

            if(buyerMap.containsKey(name)){
                buyerMap.get(name).buyFood();
            }
        }

        int totalAmountOfPurchasedFood = 0;

        for (Buyer buyer : buyerMap.values()) {
            totalAmountOfPurchasedFood += buyer.getFood();
        }

        System.out.println(totalAmountOfPurchasedFood);
    }
}
