package p08_Card_Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();

        Deck_of_Cards deck_of_cards = new Deck_of_Cards(ranks, suits);

        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Player player = new Player(reader.readLine());
            playerList.add(player);
        }

        for (Player player : playerList) {
            while (player.getCardList().size() != 5) {
                try {
                    String[] tokens = reader.readLine().split("\\s+");
                    Rank rank = Rank.valueOf(tokens[0]);
                    Suit suit = Suit.valueOf(tokens[2]);
                    Card card = new Card(rank, suit);
                    player.addCard(card, deck_of_cards);
                } catch (IllegalArgumentException iae) {
                    System.out.println("No such card exists.");
                }
            }
        }

        CardComparator cardComparator = new CardComparator();
        playerList.get(0).getCardList().sort(cardComparator);
        playerList.get(1).getCardList().sort(cardComparator);


        if (playerList.get(0).getCardList().get(0).calculatePowerOfCard() >=
                playerList.get(1).getCardList().get(0).calculatePowerOfCard()) {
            System.out.printf("%s wins with %s of %s.", playerList.get(0).getName(),
                    playerList.get(0).getCardList().get(0).getRank_power(),
                    playerList.get(0).getCardList().get(0).getSuit_power());
        } else {
            System.out.printf("%s wins with %s of %s.", playerList.get(1).getName(),
                    playerList.get(1).getCardList().get(0).getRank_power(),
                    playerList.get(1).getCardList().get(0).getSuit_power());
        }
    }
}
