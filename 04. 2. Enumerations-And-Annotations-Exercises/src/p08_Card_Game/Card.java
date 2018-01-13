package p08_Card_Game;

public class Card implements Comparable<Card> {
    private Rank rank_power;
    private Suit suit_power;

    public Card(Rank rank_power, Suit suit_power) {
        this.setRank_power(rank_power);
        this.setSuit_power(suit_power);
    }

    int calculatePowerOfCard() {
        return rank_power.getRankPower() + suit_power.getSuitPower();
    }

    Rank getRank_power() {
        return this.rank_power;
    }

    private void setRank_power(Rank rank_power) {
        this.rank_power = rank_power;
    }

    Suit getSuit_power() {
        return this.suit_power;
    }

    private void setSuit_power(Suit suit_power) {
        this.suit_power = suit_power;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.calculatePowerOfCard(), card.calculatePowerOfCard());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank_power, this.suit_power, this.calculatePowerOfCard());
    }
}
