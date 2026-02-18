package com.gla.methods.Level1;
import java.util.Scanner;

public class SmallestLargestNumber {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();
        int[] result = findSmallestAndLargest(num1, num2, num3);
        int smallest = result[0];
        int largest = result[1];
        System.out.printf("Smallest = %d\n", smallest);
        System.out.printf("Largest = %d\n", largest);

        sc.close();
    }
}

