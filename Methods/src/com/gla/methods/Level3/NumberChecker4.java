package com.gla.methods.Level3;
import java.util.Scanner;
public class NumberChecker4 {
    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    public static int[] getDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        number = Math.abs(number);
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public static boolean isPalindrome(int number) {
        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);
        return arraysEqual(digits, reversed);
    }
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();
        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);
        System.out.printf("Number: %d\n", number);
        System.out.printf("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.printf("Reversed: ");
        for (int d : reversed) System.out.print(d + " ");
        System.out.println();
        System.out.printf("Digit count: %d\n", countDigits(number));
        System.out.printf("Palindrome: %s\n", isPalindrome(number) ? "YES" : "NO");
        System.out.printf("Duck number: %s\n", isDuckNumber(number) ? "YES" : "NO");
        System.out.printf("Arrays equal: %s\n", arraysEqual(digits, reversed));
    }
}

