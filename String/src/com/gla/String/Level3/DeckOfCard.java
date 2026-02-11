package com.gla.String.Level3;
import java.util.Random;
import java.util.Scanner;

public class DeckOfCard {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King", "Ace"};
    public static String[] initializeDeck() {
        int numOfCards = SUITS.length * RANKS.length;  // 4 * 13 = 52
        String[] deck = new String[numOfCards];

        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }
    public static String[] shuffleDeck(String[] deck) {
        Random rand = new Random();
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + rand.nextInt(n - i);
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }
    public static String[][] distributeCards(String[] deck, int numPlayers) {
        int numOfCards = deck.length;  // 52
        int cardsPerPlayer = numOfCards / numPlayers;
        if (numOfCards % numPlayers != 0) {
            throw new IllegalArgumentException(
                    "Cannot evenly distribute " + numOfCards +
                            " cards to " + numPlayers + " players!");
        }
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int p = 0; p < numPlayers; p++) {
            for (int c = 0; c < cardsPerPlayer; c++) {
                playersCards[p][c] = deck[cardIndex++];
            }
        }

        return playersCards;
    }
    public static void printPlayersCards(String[][] playersCards, int numPlayers) {
        System.out.println("\n=== PLAYERS' CARDS ===");
        System.out.printf("%-8s | %s%n", "Player", "Cards");
        System.out.println("--------------------");

        for (int p = 0; p < numPlayers; p++) {
            System.out.printf("Player %d   | ", (p + 1));
            for (String card : playersCards[p]) {
                System.out.print(card + ", ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        System.out.println("Deck created: " + deck.length + " cards");
        System.out.println("Sample (first 5): " +
                java.util.Arrays.toString(java.util.Arrays.copyOf(deck, 5)));
        deck = shuffleDeck(deck);
        System.out.println("\nDeck shuffled! ");
        System.out.print("Enter number of players (1-13): ");
        int numPlayers = sc.nextInt();

        if (numPlayers < 1 || numPlayers > 13) {
            System.out.println("Invalid! Using 4 players.");
            numPlayers = 4;
        }

        try {
            String[][] playersCards = distributeCards(deck, numPlayers);
            printPlayersCards(playersCards, numPlayers);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
