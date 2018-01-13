package p03_Cards_with_Power;

public enum Suit_Powers {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int suitPower;

    Suit_Powers(int suitPower) {
        this.suitPower = suitPower;
    }

    public  int getSuitPower(){
        return this.suitPower;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
