package p02_Card_Rank;

public enum Fourteen_Ranks {

    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;


    @Override
    public String toString() {
        return "Ordinal value: " + super.ordinal()
                + "; Name value: " + super.name();
    }
}
