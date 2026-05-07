package com.pluralsight;

public class BlackJackPlayer {
    private final String name;
    private final Hand hand;

    public BlackJackPlayer(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }



    public void hitMe(Deck deck) {
        this.hand.deal(deck.deal());
    }

    public int getHandPoint() {
        int points = this.hand.getValue();
        if (points > 21) {
            int remove = aceHandling();
            return points+remove;
        }
        return points;
    }

    public String seeHand() {
        StringBuilder showCards = new StringBuilder();
        for (Card card : this.hand.getCards()) {
            card.flip();
            showCards.append("Suit: ").append(card.getSuit()).append(" Value: ").append(card.getValue()).append(" ");
            card.flip();
        }
        return showCards.toString();

    }

    public String getName() {
        return name;
    }

    public int aceHandling() {
        for (Card card : this.hand.getCards()) {
            if (card.isAce()) {
                return -10;
            }
        }
        return 0;
    }

}
