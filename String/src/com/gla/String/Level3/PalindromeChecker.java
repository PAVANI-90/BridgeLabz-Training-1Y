package com.gla.String.Level3;
import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindromeLogic1(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindromeLogic2(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeLogic2(str, start + 1, end - 1);
    }
    public static char[] reverseString(String str) {
        char[] reversed = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            reversed[i] = str.charAt(str.length() - 1 - i);
        }
        return reversed;
    }
    public static boolean isPalindromeLogic3(String str) {
        char[] original = str.toCharArray();
        char[] reversed = reverseString(str);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    public static void displayResults(String input, boolean[] results) {
        System.out.println("\n PALINDROME CHECK - 3 LOGICS ");
        System.out.printf("%-25s | %-10s%n", "Input", "Palindrome?");
        System.out.println("------------");
        System.out.printf("%-25s | %s%n", input, results[0] ? "YES" : "NO");
        System.out.printf("%-25s | %s (Logic 1)%n", "Two Pointers", results[0] ? "YES" : "NO");
        System.out.printf("%-25s | %s (Logic 2)%n", "Recursive", results[1] ? "YES" : "NO");
        System.out.printf("%-25s | %s (Logic 3)%n", "Array Reverse", results[2] ? "YES" : "NO");
        System.out.println("-----------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Empty string!");
            return;
        }
        boolean logic1 = isPalindromeLogic1(input);
        boolean logic2 = isPalindromeLogic2(input, 0, input.length() - 1);
        boolean logic3 = isPalindromeLogic3(input);
        displayResults(input, new boolean[]{logic1, logic2, logic3});

        sc.close();
    }
}

