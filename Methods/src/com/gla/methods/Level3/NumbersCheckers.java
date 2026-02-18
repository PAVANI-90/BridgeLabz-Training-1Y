package com.gla.methods.Level3;
import java.util.Scanner;

public class NumbersCheckers {
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
    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    public static double sumSquaresDigits(int[] digits) {
        double sumSquares = 0;
        for (int digit : digits) {
            sumSquares += Math.pow(digit, 2);
        }
        return sumSquares;
    }
    public static boolean isHarshadNumber(int number) {
        int[] digits = getDigits(number);
        int digitSum = sumDigits(digits);
        return Math.abs(number) % digitSum == 0;
    }
    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int digit : digits) {
            frequency[digit][0] = digit;
            frequency[digit][1]++;
        }
        return frequency;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();
        int[] digits = getDigits(number);
        System.out.printf("Number: %d\n", number);
        System.out.printf("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.printf("Digit count: %d\n", countDigits(number));
        System.out.printf("Sum of digits: %d\n", sumDigits(digits));
        System.out.printf("Sum of squares: %.0f\n", sumSquaresDigits(digits));
        System.out.printf("Harshad number: %s\n", isHarshadNumber(number) ? "YES" : "NO");
        System.out.println("\nDigit Frequency:");
        System.out.println("Digit | Count");
        System.out.println("--|--");
        int[][] freq = findDigitFrequency(digits);
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0) {
                System.out.printf("  %d   |  %d\n", freq[i][0], freq[i][1]);
            }
        }
    }
}

