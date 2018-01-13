package p08_Card_Game;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card firstCard, Card secondCard) {
        return Integer.compare(secondCard.calculatePowerOfCard(), firstCard.calculatePowerOfCard());
    }
}
