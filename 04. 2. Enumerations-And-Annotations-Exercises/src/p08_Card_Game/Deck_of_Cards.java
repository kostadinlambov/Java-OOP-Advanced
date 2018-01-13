package p08_Card_Game;

import java.util.*;

public class Deck_of_Cards {
    private Rank[] ranks;
    private Suit[] suits;
    private Map<Suit, List<Rank>> deckOfCards;

    public Deck_of_Cards(Rank[] ranks, Suit[] suits) {
        this.ranks = ranks;
        this.suits = suits;
        this.setDeckOfCards();
    }

    void setDeckOfCards() {
        this.deckOfCards = new LinkedHashMap<>();
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                if (!this.deckOfCards.containsKey(suit)) {
                    this.deckOfCards.putIfAbsent(suit, new ArrayList<>());
                }
                this.deckOfCards.get(suit).add(rank);
            }
        }
        System.out.println();
    }

    Map<Suit, List<Rank>> getDeckOfCards() {
        return Collections.unmodifiableMap(this.deckOfCards);
    }

    boolean isCardInTheDeck(Suit suit, Rank rank) {
        if (this.deckOfCards.containsKey(suit)) {
            if (!this.deckOfCards.get(suit).contains(rank)) {
                System.out.println("Card is not in the deck.");
                return false;
            } else {
                this.deckOfCards.get(suit).remove(rank);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                sb.append(rank.name()).append(" of ")
                        .append(suit.name()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
