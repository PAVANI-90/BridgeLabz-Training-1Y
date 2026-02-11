package com.gla.String.Level2;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static String computerChoice() {
        Random rand = new Random();
        int choice = rand.nextInt(3);
        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: return "Rock";
        }
    }
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Tie";
        }
        if (user.equals("Rock") && computer.equals("Scissors")) return "User";
        if (computer.equals("Rock") && user.equals("Scissors")) return "Computer";
        if (user.equals("Paper") && computer.equals("Rock")) return "User";
        if (computer.equals("Paper") && user.equals("Rock")) return "Computer";
        if (user.equals("Scissors") && computer.equals("Paper")) return "User";
        if (computer.equals("Paper") && user.equals("Scissors")) return "Computer";

        return "Invalid";
    }
    public static String[][] calculateStats(int userWins, int computerWins, int ties, int totalGames) {
        double userPct = (userWins * 100.0 / totalGames);
        double compPct = (computerWins * 100.0 / totalGames);

        return new String[][]{
                {"Player Wins", String.valueOf(userWins), String.format("%.1f%%", userPct)},
                {"Computer Wins", String.valueOf(computerWins), String.format("%.1f%%", compPct)},
                {"Ties", String.valueOf(ties), "N/A"}
        };
    }
    public static void displayGame(int gameNum, String userChoice, String compChoice, String winner) {
        System.out.printf("\nGame %d: User(%s) vs Computer(%s) → %s\n",
                gameNum, userChoice, compChoice, winner);
    }

    public static void displayStatsTable(String[][] stats) {
        System.out.println("\n=== FINAL STATISTICS ===");
        System.out.printf("%-12s | %-8s | %-8s%n", "Category", "Count", "Percentage");
        System.out.println("--------------------");
        for (String[] row : stats) {
            System.out.printf("%-12s | %-8s | %-8s%n", row[0], row[1], row[2]);
        }
        System.out.println("---------------");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter number of games: ");
        int numGames = sc.nextInt();

        int userWins = 0, computerWins = 0, ties = 0;

        // Play all games
        for (int i = 1; i <= numGames; i++) {
            System.out.printf("\nGame %d - Enter choice (Rock/Paper/Scissors): ", i);
            String userChoice = sc.next().trim();

            // Validate input
            if (!userChoice.equalsIgnoreCase("Rock") &&
                    !userChoice.equalsIgnoreCase("Paper") &&
                    !userChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid! Defaulting to Rock.");
                userChoice = "Rock";
            }

            String compChoice = computerChoice();
            String winner = findWinner(userChoice, compChoice);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else ties++;
            displayGame(i, userChoice, compChoice, winner);
        }
        String[][] stats = calculateStats(userWins, computerWins, ties, numGames);
        displayStatsTable(stats);
        if (userWins > computerWins) {
            System.out.println(" PLAYER WINS THE MATCH!");
        } else if (computerWins > userWins) {
            System.out.println(" COMPUTER WINS THE MATCH!");
        } else {
            System.out.println(" MATCH ENDS IN A TIE!");
        }

        sc.close();
    }
}


