package com.pluralsight;

public class Table {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Hand p1 = new Hand();
        Hand p2 = new Hand();
        Hand p3 = new Hand();

        p1.deal(deck.deal());
        p2.deal(deck.deal());
        p3.deal(deck.deal());

        p1.deal(deck.deal());
        p2.deal(deck.deal());
        p3.deal(deck.deal());

        System.out.println("P1 hand: " +p1.getValue());
        System.out.println("P1 hand: " +p2.getValue());
        System.out.println("P1 hand: " +p3.getValue());
    }
}
