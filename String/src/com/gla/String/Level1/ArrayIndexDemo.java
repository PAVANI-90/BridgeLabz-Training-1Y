package com.gla.String.Level1;
import java.util.Scanner;

public class ArrayIndexDemo {
    public static String[] getNamesArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int size = sc.nextInt();
        sc.nextLine();

        String[] names = new String[size];
        System.out.println("Enter " + size + " names:");
        for (int i = 0; i < size; i++) {
            names[i] = sc.nextLine();
        }
        return names;
    }
    public static void generateArrayIndexOutOfBounds(String[] names) {
        System.out.println("Array length: " + names.length);
        System.out.println("Accessing index 5: " + names[5]);
    }
    public static void handleArrayIndexOutOfBounds(String[] names) {
        try {
            System.out.println("Array length: " + names.length);
            System.out.println("Trying index 5...");
            String name = names[5];
            System.out.println("Name at index 5: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" Caught ArrayIndexOutOfBoundsException!");
            System.out.println("Valid indices: 0 to " + (names.length - 1));
        } catch (RuntimeException e) {
            System.out.println(" Caught generic RuntimeException!");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] names = getNamesArray();

        System.out.println("\n 1. GENERATE Exception (CRASH) ");


        System.out.println("\n2. HANDLE Exception (SAFE) ");
        handleArrayIndexOutOfBounds(names);

        System.out.println("\nProgram continues safely!");
    }
}

