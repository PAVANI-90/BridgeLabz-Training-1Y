package com.gla.String.Level3;
import java.util.Scanner;

public class FirstNonRepeatingString{
    public static char findFirstNonRepeating(String str) {
        int[] frequency = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            frequency[(int)ch]++;
        }
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (frequency[(int)ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }
    public static void displayAnalysis(String str, char result) {
        System.out.println("\n=== FIRST NON-REPEATING CHARACTER ===");
        System.out.println("Input string: '" + str + "'");

        if (result != '\0') {
            System.out.println("First non-repeating: '" + result + "'");
        } else {
            System.out.println("No non-repeating character found!");
        }
    }
    public static void showFrequencies(String str) {
        int[] freq = new int[256];
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[(int)ch]++;
        }

        System.out.println("\n--- Frequency Table (Printable chars only) ---");
        System.out.printf("%-8s | %-4s%n", "Char", "Freq");
        System.out.println("--------");

        for (int i = 32; i < 127; i++) {
            if (freq[i] > 0) {
                System.out.printf("%-8c | %-4d%n", (char)i, freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char firstNonRepeating = findFirstNonRepeating(input);
        displayAnalysis(input, firstNonRepeating);
        showFrequencies(input);

        sc.close();
    }
}
