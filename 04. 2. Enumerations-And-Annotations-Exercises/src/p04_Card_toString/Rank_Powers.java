package p04_Card_toString;

public enum Rank_Powers {
    ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int rankPower;

    Rank_Powers(int power) {
        this.rankPower = power;
    }

    public int getRankPower(){
        return this.rankPower;
    }

    @Override
    public String toString() {
        return this.name();
    }
}