package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Table tableSection7 = new Table(deck);
        tableSection7.CreatePlayers();
        tableSection7.initialTwoCard();
        for (BlackJackPlayer p:  tableSection7.players)
            tableSection7.dealCards(p);

        BlackJackPlayer winner = Table.pickWinner(tableSection7.players);
        System.out.println("Winner is: " + winner.getName());
        Table.showPlayerCards(winner);




    }
}
