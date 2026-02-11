package com.gla.String.Level3;
import java.util.Scanner;

public class FrequencyCharacter {
    public static String[][] findCharFrequencies(String str) {
        int[] frequency = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            frequency[(int)ch]++;
        }
        int nonZeroCount = 0;
        for (int count : frequency) {
            if (count > 0) nonZeroCount++;
        }
        String[][] result = new String[nonZeroCount][2];
        int index = 0;

        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[index][0] = String.valueOf((char)i);
                result[index][1] = String.valueOf(frequency[i]);
                index++;
            }
        }

        return result;
    }
    public static void displayFrequencyTable(String[][] frequencies) {
        System.out.println("\n=== CHARACTER FREQUENCY TABLE ===");
        System.out.printf("%-12s | %-8s | %-6s%n", "Character", "Freq", "%");
        System.out.println("--------------");

        int totalChars = 0;
        for (String[] row : frequencies) {
            int freq = Integer.parseInt(row[1]);
            totalChars += freq;
        }

        for (String[] row : frequencies) {
            int freq = Integer.parseInt(row[1]);
            double percentage = (freq * 100.0 / totalChars);
            System.out.printf("%-12s | %-8d | %5.1f%%%n",
                    row[0], freq, percentage);
        }
        System.out.println("----------------");
        System.out.printf("Total characters: %d%n", totalChars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] frequencies = findCharFrequencies(input);
        displayFrequencyTable(frequencies);

        sc.close();
    }
}

