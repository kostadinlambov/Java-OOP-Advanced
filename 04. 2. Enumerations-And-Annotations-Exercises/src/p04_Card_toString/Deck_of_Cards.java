package p04_Card_toString;

public class Deck_of_Cards {
    private Rank_Powers rank_power;
    private Suit_Powers suit_power;

    public Deck_of_Cards(Rank_Powers rank_power, Suit_Powers suit_power) {
        this.rank_power = rank_power;
        this.suit_power = suit_power;
    }

    public int calculatePowerOfCard(){
        return rank_power.getRankPower() + suit_power.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank_power, this.suit_power, this.calculatePowerOfCard());
    }
}
