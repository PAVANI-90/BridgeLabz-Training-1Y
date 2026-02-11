package com.gla.String.Level2;
import java.util.Scanner;

public class VowelConsonantCharacterType {
    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);  // ch + ('a' - 'A')
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    public static String[][] findVowelsConsonants(String str) {
        String[][] result = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }
        return result;
    }
    public static void displayTable(String[][] table) {
        System.out.println("\n--- Vowel & Consonant Analysis ---");
        System.out.printf("%-12s | %-12s%n", "Character", "Type");
        System.out.println("----------------");

        for (String[] row : table) {
            System.out.printf("%-12s | %-12s%n", row[0], row[1]);
        }
        System.out.println("-------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] analysis = findVowelsConsonants(input);
        displayTable(analysis);

        sc.close();
    }
}

