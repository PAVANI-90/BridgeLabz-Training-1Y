package com.gla.methods.Level2;
import java.util.Scanner;

public class NumberChecker {
    public static boolean isPositive(int number) {
        return number > 0;
    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static int compare(int number1, int number2) {
        if (number1 > number2) return 1;
        if (number1 < number2) return -1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        System.out.println("\n Analysis ");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (isPositive(num)) {
                System.out.printf("Number %d: POSITIVE ", num);
                if (isEven(num)) {
                    System.out.println("and EVEN");
                } else {
                    System.out.println("and ODD");
                }
            } else {
                System.out.printf("Number %d: NEGATIVE\n", num);
            }
        }
        int first = numbers[0];
        int last = numbers[4];
        int comparison = compare(first, last);
        System.out.printf("\nFirst (%d) vs Last (%d): ", first, last);
        if (comparison == 1) {
            System.out.println("FIRST > LAST");
        } else if (comparison == 0) {
            System.out.println("FIRST == LAST");
        } else {
            System.out.println("FIRST < LAST");
        }
        sc.close();
    }
}

