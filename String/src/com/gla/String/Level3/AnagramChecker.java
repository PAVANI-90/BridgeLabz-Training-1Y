package com.gla.String.Level3;
import java.util.Scanner;

public class AnagramChecker {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            freq1[(int)str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            freq2[(int)str2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
    public static void showFrequencyComparison(String str1, String str2, boolean isAnagram) {
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            freq1[(int)str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            freq2[(int)str2.charAt(i)]++;
        }

        System.out.println("\n FREQUENCY COMPARISON ");
        System.out.printf("%-12s | %-8s | %-8s%n", "Character", str1, str2);
        System.out.println("-------------");

        boolean allMatch = true;
        for (int i = 32; i < 127; i++) {
            if (freq1[i] > 0 || freq2[i] > 0) {
                System.out.printf("%-12c | %-8d | %-8d%n",
                        (char)i, freq1[i], freq2[i]);
                if (freq1[i] != freq2[i]) allMatch = false;
            }
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine().trim();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine().trim();
        boolean result = areAnagrams(str1, str2);
        System.out.println("\n ANAGRAM CHECK ");
        System.out.printf("%-20s | %s%n", str1, str2);
        System.out.println("-------------------------");
        System.out.println("Are Anagrams: " + (result ? "YES" : " NO"));
        System.out.printf("Lengths match: %s%n", str1.length() == str2.length() ? "YES" : "NO");
        showFrequencyComparison(str1, str2, result);

        sc.close();
    }
}
