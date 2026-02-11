package com.gla.String.Level3;
import java.util.Scanner;

public class NestedLoopFrequency {

    // Method a: Find frequencies using NESTED LOOPS (mark duplicates as '0')
    public static String[] findCharFrequencies(String str) {
        // Step i: Convert to char array + frequency array
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] frequency = new int[len];
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                frequency[i] = 1;
                for (int j = i + 1; j < len; j++) {
                    if (chars[i] == chars[j]) {
                        frequency[i]++;
                        chars[j] = '0';
                    }
                }
            }
        }
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0' && frequency[i] > 0) {
                result[i] = chars[i] + ":" + frequency[i];
            }
        }

        return result;
    }
    public static void displayFrequencyTable(String input, String[] frequencies) {
        System.out.println("\n NESTED LOOP FREQUENCY ANALYSIS  ");
        System.out.printf("%-12s | %-8s | %-6s%n", "Character", "Freq", "%");
        System.out.println("-----------------");

        int totalChars = input.length();
        int uniqueCount = 0;
        int totalFreq = 0;
        for (String entry : frequencies) {
            if (entry != null && entry.contains(":")) {
                String[] parts = entry.split(":");
                char ch = parts[0].charAt(0);
                int freq = Integer.parseInt(parts[1]);

                double pct = (freq * 100.0 / totalChars);
                System.out.printf("%-12c | %-8d | %5.1f%%%n", ch, freq, pct);

                uniqueCount++;
                totalFreq += freq;
            }
        }
        System.out.println("--------------");
        System.out.printf("Total chars: %d | Unique: %d%n", totalChars, uniqueCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[] frequencies = findCharFrequencies(input);
        displayFrequencyTable(input, frequencies);

        sc.close();
    }
}

