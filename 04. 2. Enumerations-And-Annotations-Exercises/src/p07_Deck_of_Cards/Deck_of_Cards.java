package p07_Deck_of_Cards;

public class Deck_of_Cards {
    private Rank[] ranks;
    private Suit[] suits;

    public Deck_of_Cards(Rank[] ranks, Suit[] suits) {
        this.ranks = ranks;
        this.suits = suits;
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
