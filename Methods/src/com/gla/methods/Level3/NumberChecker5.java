package com.gla.methods.Level3;
import java.util.Arrays;
import java.util.Scanner;
public class NumberChecker5 {
    private static int[] getDigits(int number) {
        int temp = Math.abs(number);
        int count = 0;
        int n = temp;
        while (n > 0) {
            count++;
            n /= 10;
        }
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }
    private static int sumDigits(int number) {
        int[] digits = getDigits(number);
        return Arrays.stream(digits).sum();
    }
    private static int productDigits(int number) {
        int[] digits = getDigits(number);
        int product = 1;
        for (int digit : digits) {
            product *= digit;
        }
        return product;
    }
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // b: Neon number (sum digits of n² == n)
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        return sumDigits(square) == Math.abs(number);
    }
    public static boolean isSpyNumber(int number) {
        return sumDigits(number) == productDigits(number);
    }
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        int digits = getDigits(number).length;
        int power = (int) Math.pow(10, digits);
        return square % power == Math.abs(number);
    }
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || Math.abs(number) % 10 == 7;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();
        System.out.printf("\nNumber: %d\n", number);
        System.out.printf("Prime: %s\n", isPrime(number));
        System.out.printf("Neon: %s\n", isNeonNumber(number));
        System.out.printf("Spy: %s\n", isSpyNumber(number));
        System.out.printf("Automorphic: %s\n", isAutomorphic(number));
        System.out.printf("Buzz: %s\n", isBuzzNumber(number));
    }
}

