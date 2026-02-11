package com.gla.String.Level2;
import java.util.Scanner;
import java.util.Random;

public class StudentVotingEligibility {
    public static int[] generateStudentAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(91);  // 10-100 (2-digit + 100)
        }
        return ages;
    }
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);
            if (age < 0) {
                result[i][1] = "false (negative)";
            }
            else if (age >= 18) {
                result[i][1] = "true";
            }
            else {
                result[i][1] = "false (<18)";
            }
        }
        return result;
    }
    public static void displayTable(String[][] table) {
        System.out.println("\n--- Student Voting Eligibility ---");
        System.out.printf("%-8s | %-12s%n", "Student", "Age | Can Vote");
        System.out.println("---------------");

        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-8s | %-3s | %-12s%n",
                    "S" + (i+1),
                    table[i][0],
                    table[i][1]);
        }
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students (default 10): ");
        int n = sc.hasNextInt() ? sc.nextInt() : 10;
        if (n <= 0) n = 10;
        int[] ages = generateStudentAges(n);
        String[][] eligibility = checkVotingEligibility(ages);
        displayTable(eligibility);
        int canVote = 0;
        for (String[] row : eligibility) {
            if (row[1].equals("true")) {
                canVote++;
            }
        }
        System.out.printf("\nTotal students who can vote: %d/%d (%.1f%%)\n",
                canVote, n, (canVote * 100.0 / n));

        sc.close();
    }
}

