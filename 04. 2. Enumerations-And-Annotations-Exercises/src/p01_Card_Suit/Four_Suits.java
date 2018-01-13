package p01_Card_Suit;

public enum Four_Suits {

    CLUBS, DIAMONDS, HEARTS, SPADES;

    @Override
    public String toString() {
        return "Ordinal value: " + super.ordinal()
                + "; Name value: " + super.name();
    }
}
