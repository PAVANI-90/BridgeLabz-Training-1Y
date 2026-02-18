package com.gla.methods.Level3;
import java.util.Scanner;
public class NumberChecker6 {
    private static int sumProperDivisors(int number) {
        if (number <= 1) return 0;
        int sum = 1;  // 1 is always proper divisor
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i && number / i != number) {
                    sum += number / i;
                }
            }
        }
        return sum;
    }
    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static boolean isPerfect(int number) {
        if (number <= 0) return false;
        return sumProperDivisors(number) == number;
    }
    public static boolean isAbundant(int number) {
        if (number <= 0) return false;
        return sumProperDivisors(number) > number;
    }
    public static boolean isDeficient(int number) {
        if (number <= 0) return false;
        return sumProperDivisors(number) < number;
    }
    public static boolean isStrongNumber(int number) {
        int[] digits = getDigits(number);
        int sumFact = 0;
        for (int digit : digits) {
            sumFact += factorial(digit);
        }
        return sumFact == Math.abs(number);
    }
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        sc.close();
        int properDivSum = sumProperDivisors(number);
        System.out.printf("\nNumber: %d\n", number);
        System.out.printf("Sum of proper divisors: %d\n", properDivSum);
        System.out.printf("Perfect: %s\n", isPerfect(number));
        System.out.printf("Abundant: %s\n", isAbundant(number));
        System.out.printf("Deficient: %s\n", isDeficient(number));
        System.out.printf("Strong: %s\n", isStrongNumber(number));
    }
}

