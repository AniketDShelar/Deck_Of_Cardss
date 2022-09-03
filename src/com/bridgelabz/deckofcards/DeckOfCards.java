package com.bridgelabz.deckofcards;

import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {
    public static final Scanner scan = new Scanner(System.in);
    public ArrayList<String> cardsDeck = new ArrayList<>();
    String[] suit = {"Clubs","Diamonds","Hearts","Spades"};
    String[] rank = {"2","3","4","5","6","7","8","9","10","Jack", "Queen", "King", "Ace"};
    int numOfCards = suit.length * rank.length;

    public void deckOfCards(){

        System.out.println("Number of cards in deck : " +numOfCards);
        for(int i = 0; i < rank.length; i++){
            for(int j = 0; j < suit.length; j++){
                cardsDeck.add(rank[i] + "-->" + suit[j]);
            }
        }
        toDisplay(cardsDeck);
    }
    public static void toDisplay(ArrayList<String> cardsDeck) {
        System.out.println("\nCards in Deck:");
        for (String element : cardsDeck) {
            System.out.println(element);
        }
        System.out.println();
    }
    public void noOfPlayers() {
        System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");
        int player = scan.nextInt();
        if (player >= 2 && player <= 4) {
            System.out.println("\n" + player + " players will play the game");
            sequenceOfPlay(player);
        } else {
            System.out.println("Please enter number of players in the Range");
            noOfPlayers();
        }
    }
    public void sequenceOfPlay(int player) {
        System.out.println("\nSequence of cards are below : ");
        toShuffle(cardsDeck, player);
    }
    public static ArrayList<String> toShuffle(ArrayList<String> cardsDeck, int player) {
        System.out.println("Shuffling the cards before Distribution");
        ArrayList<String> temp = new ArrayList<>();
        while (!cardsDeck.isEmpty()) {
            int random = (int) (Math.random() * cardsDeck.size());
            temp.add(cardsDeck.get(random));
            cardsDeck.remove(random);
        }
        cardsDeck = temp;
        toDisplay(cardsDeck);
        cardDistribution(cardsDeck, player);
        return cardsDeck;
    }
    public static void cardDistribution(ArrayList<String> cardsDeck, int player) {
        // This loop will iterate for no of players
        for (int i = 0; i < player; i++) {
            System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
            // This loop will iterate for no of cards for each player
            for (int j = 0; j < 9; j++) {
                System.out.print("\t" + cardsDeck.get(i+j*player));
            }
        }
        System.out.println();
    }
    public void displayCardsInSequence(){
        int counter = 0;
        for(int i = 0; i < suit.length; i++){
            for(int j = 0; j < rank.length; j++){
                cardsDeck.add(suit[i] +"----"+ rank[j]);
            }
        }
        System.out.println(cardsDeck);
    }
}
