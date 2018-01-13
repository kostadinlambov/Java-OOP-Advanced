package p06_Custom_Enum_Annotation;

public class Deck_of_Cards implements Comparable<Deck_of_Cards> {
    private Rank rank_power;
    private Suit suit_power;

    public Deck_of_Cards(Rank rank_power, Suit suit_power) {
        this.rank_power = rank_power;
        this.suit_power = suit_power;
    }

    public int calculatePowerOfCard(){
        return rank_power.getRankPower() + suit_power.getSuitPower();
    }

    @Override
    public int compareTo(Deck_of_Cards card) {
        return Integer.compare(this.calculatePowerOfCard(), card.calculatePowerOfCard());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank_power, this.suit_power, this.calculatePowerOfCard());
    }
}
