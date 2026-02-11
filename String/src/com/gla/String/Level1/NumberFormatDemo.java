package com.gla.String.Level1;

import java.util.Scanner;

public class NumberFormatDemo {
    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number as text: ");
        return sc.next();
    }
    public static void generateNumberFormatException(String text) {
        System.out.println("Input: '" + text + "'");
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }
    public static void handleNumberFormatException(String text) {
        try {
            System.out.println("Input: '" + text + "'");
            int number = Integer.parseInt(text);
            System.out.println(" Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println(" Caught NumberFormatException!");
            System.out.println("Error: '" + text + "' is not a valid integer");
        } catch (RuntimeException e) {
            System.out.println(" Caught generic RuntimeException!");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String input = getUserInput();
        System.out.println("\n 1. GENERATE Exception (CRASH) ");
        System.out.println("\n 2. HANDLE Exception (SAFE) ");
        handleNumberFormatException(input);

        System.out.println("\n Program continues safely!");
    }
}
