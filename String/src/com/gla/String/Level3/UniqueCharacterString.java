package com.gla.String.Level3;
import java.util.Scanner;

public class UniqueCharacterString {
    public static int manualLength(String str) {
        int len = 0;
        try {
            while (true) {
                str.charAt(len);
                len++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return len;
        }
    }
    public static char[] findUniqueChars(String str) {
        int len = manualLength(str);
        boolean[] seen = new boolean[256];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (!seen[(int)ch]) {
                seen[(int)ch] = true;
                uniqueCount++;
            }
        }
        char[] uniqueChars = new char[uniqueCount];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (!seen[(int)ch]) {
                seen[(int)ch] = true;  // Mark as seen now
                uniqueChars[index++] = ch;
            }
        }

        return uniqueChars;
    }
    public static void displayResults(String original, char[] unique) {
        System.out.println("\n=== UNIQUE CHARACTERS ANALYSIS ===");
        System.out.println("Original string: '" + original + "'");
        System.out.print("Unique chars:    ");

        for (char ch : unique) {
            System.out.print("[" + ch + "] ");
        }
        System.out.println();
        System.out.printf("Total unique: %d / %d chars\n",
                unique.length, manualLength(original));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] uniqueChars = findUniqueChars(input);
        displayResults(input, uniqueChars);

        sc.close();
    }
}
