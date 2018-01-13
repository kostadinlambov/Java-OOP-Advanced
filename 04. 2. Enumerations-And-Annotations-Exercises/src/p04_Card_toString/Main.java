package p04_Card_toString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Rank_Powers rank_power = Rank_Powers.valueOf(reader.readLine().toUpperCase());
        Suit_Powers suit_power = Suit_Powers.valueOf(reader.readLine().toUpperCase());

        Deck_of_Cards card = new Deck_of_Cards(rank_power, suit_power);

        System.out.println(card);
    }
}
