package p08_Card_Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;;
    private List<Card> cardList;

    Player(String name) {
        this.setName(name);
        this.setCardList();
    }

    void addCard(Card card, Deck_of_Cards deck_of_cards) {
        if (deck_of_cards.isCardInTheDeck(card.getSuit_power(), card.getRank_power())) {
            cardList.add(card);
        }
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCardList() {
        this.cardList = new ArrayList<>();
    }

    public List<Card> getCardList() {
        return this.cardList;
    }
}
