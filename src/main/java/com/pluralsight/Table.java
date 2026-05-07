package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    private final Deck deck;
    public ArrayList<BlackJackPlayer> players;

    public Table(Deck deck) {
        this.deck = deck;
        players = new ArrayList<>();
    }

    public void CreatePlayers() {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                Welcome to to 7TableCasino
                how many player will be playing today:
                """;
        System.out.println(menu);
        int numPlayers = Integer.parseInt(scanner.nextLine()) + 1;
        for (int i = 1; i < numPlayers; i++) {
            System.out.println("Please enter player " + i + ") name");
            String name = scanner.nextLine();
           this.players.add((new BlackJackPlayer(name, new Hand())));

        }

    }
    public  void dealCards(BlackJackPlayer player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player "+player.getName()+"|");
        boolean running = true;
        do {
            System.out.println(player.seeHand());
            System.out.println(player.getHandPoint());
            System.out.println("-Do you want (Hit/Stay) : ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("hit")){
                player.hitMe(this.deck);
            }

            else
                running = false;

        }while (running);

    }

    public void initialTwoCard() {
        for (BlackJackPlayer p : this.players){
            p.hitMe(this.deck);
            p.hitMe(this.deck);
        }

    }

    public static void showPlayerCards(BlackJackPlayer player){
        System.out.println(player.seeHand());
    }

    public static BlackJackPlayer pickWinner(ArrayList<BlackJackPlayer> players){
       // we assume the first player have higherHand
        BlackJackPlayer winner = new BlackJackPlayer("tmp",new Hand());
        for(BlackJackPlayer player : players){
            if (player.getHandPoint()> winner.getHandPoint())
                winner =player;
        }
        return winner;
    }


}


