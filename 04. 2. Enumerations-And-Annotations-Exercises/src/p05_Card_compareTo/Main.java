package p05_Card_compareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Deck_of_Cards> cardsList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Rank_Powers rank_power = Rank_Powers.valueOf(reader.readLine().toUpperCase());
            Suit_Powers suit_power = Suit_Powers.valueOf(reader.readLine().toUpperCase());

            Deck_of_Cards card = new Deck_of_Cards(rank_power, suit_power);

            cardsList.add(card);
        }

        if(cardsList.get(0).compareTo(cardsList.get(1)) >= 0){
            System.out.println(cardsList.get(0));
        }else{
            System.out.println(cardsList.get(1));
        }
    }
}
