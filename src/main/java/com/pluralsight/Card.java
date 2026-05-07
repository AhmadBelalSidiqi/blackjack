package com.pluralsight;

public class Card {
    private final String suit;
    private final String value;
    private boolean isFaceUp;
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit(){
        // only return the suit if the card is face up
        if(isFaceUp){
            return suit;
        } else {
            return "#";
        }
    }
    public String getValue(){
        // only return the value if the card is face up
        if(isFaceUp){
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }
    public String getCardFaceUp(){
        return "Suite: "+this.suit+" Value: "+this.value;
    }
    public int getPointValue(){
        // only return the value if the card is face up
        if(isFaceUp){
            try {
                return Integer.parseInt(this.value);
            } catch (NumberFormatException ignored) {

            }
            switch (this.value){
                case "J","Q","K"-> {
                    return 10;
                }
                case  "A" ->
                {
                    return 11;
                }
                default ->
                {
                    return 0;
                }
            }
        } else {
            return 0;
        }

    }
    public boolean isAce(){
        return this.value.equalsIgnoreCase("A");

    }
    public boolean isFaceUp(){
        return isFaceUp;
    }
    public void flip(){
        isFaceUp = !isFaceUp;
    }
}
