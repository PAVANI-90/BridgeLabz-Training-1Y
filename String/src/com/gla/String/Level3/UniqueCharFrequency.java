package com.gla.String.Level3;
import java.util.Scanner;

public class UniqueCharFrequency {
    public static char[] uniqueCharacters(String str) {
        int len = str.length();
        char[] temp = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = current;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }
    public static String[][] charFrequencies(String str) {
        int len = str.length();
        int[] frequency = new int[256];
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            frequency[(int)ch]++;
        }
        char[] uniques = uniqueCharacters(str);
        String[][] result = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            char ch = uniques[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[(int)ch]);
        }

        return result;
    }
    public static void displayTable(String str, String[][] frequencies) {
        System.out.println("\n=== CHARACTER FREQUENCY (Unique First) ===");
        System.out.printf("%-12s | %-8s | %-6s%n", "Character", "Freq", "%");
        System.out.println("-------------");

        int total = str.length();
        for (String[] row : frequencies) {
            int freq = Integer.parseInt(row[1]);
            double pct = (freq * 100.0 / total);
            System.out.printf("%-12s | %-8d | %5.1f%%%n", row[0], freq, pct);
        }
        System.out.println("------------");
        System.out.printf("Total chars: %d | Unique chars: %d%n", total, frequencies.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] frequencies = charFrequencies(input);
        displayTable(input, frequencies);

        sc.close();
    }
}
