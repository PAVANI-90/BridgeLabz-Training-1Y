package com.gla.String.Level1;
import java.util.Scanner;

public class IllegalArgumentDemo {
    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }
    public static void generateIllegalArgument(String text) {
        System.out.println("String: '" + text + "' (length: " + text.length() + ")");
        System.out.println("substring(10,5): " + text.substring(10, 5));
    }
    public static void handleIllegalArgument(String text) {
        try {
            System.out.println("String: '" + text + "' (length: " + text.length() + ")");
            System.out.println("Trying substring(10,5)...");
            String result = text.substring(10, 5);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Caught IllegalArgumentException!");
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException!");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String input = getUserInput();

        System.out.println("\n1. GENERATE Exception (CRASH) ");

        System.out.println("\n 2. HANDLE Exception (SAFE) ");
        handleIllegalArgument(input);

        System.out.println("\n Program continues safely!");
    }
}

