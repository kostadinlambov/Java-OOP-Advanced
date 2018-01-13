package p01_Card_Suit;

import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {

        Four_Suits[] suits = Four_Suits.values();

        System.out.println("Card Suits:");
        for (Four_Suits suit : suits) {
            System.out.println(suit);
        }
    }
}
