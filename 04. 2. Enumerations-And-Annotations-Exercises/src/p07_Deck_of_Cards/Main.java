package p07_Deck_of_Cards;

public class Main {
    public static void main(String[] args) {
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();

        Deck_of_Cards deck_of_cards = new Deck_of_Cards(ranks, suits);

        System.out.println(deck_of_cards);
    }
}
