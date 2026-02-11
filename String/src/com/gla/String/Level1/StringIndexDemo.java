package com.gla.String.Level1;
import java.util.Scanner;

public class StringIndexDemo {
    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.next();
    }
    public static void generateIndexOutOfBounds(String text) {
        System.out.println("String: '" + text + "' (length: " + text.length() + ")");
        System.out.println("Accessing index 10: " + text.charAt(10));  // ❌ CRASH!
    }
    public static void handleIndexOutOfBounds(String text) {
        try {
            System.out.println("String: '" + text + "' (length: " + text.length() + ")");
            System.out.println("Trying index 10: " + text.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("✅ Caught StringIndexOutOfBoundsException!");
            System.out.println("Safe message: Index 10 is out of bounds for length " + text.length());
        }
    }

    public static void main(String[] args) {
        String input = getUserInput();

        System.out.println("\n 1. GENERATE Exception (CRASH) ");
        System.out.println("\n 2. HANDLE Exception (SAFE) ");
        handleIndexOutOfBounds(input);

        System.out.println("\n Program continues safely!");
    }
}

