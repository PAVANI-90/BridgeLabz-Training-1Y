package com.gla.methods.Level3;
import java.util.Scanner;
public class NumberChecker {
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
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
    public static boolean isArmstrongNumber(int number) {
        int[] digits = getDigits(number);
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += (int) Math.pow(digit, power);
        }
        return sum == Math.abs(number);
    }
    public static int[] findLargestSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest == Integer.MIN_VALUE ? -1 : secondLargest};
    }
    public static int[] findSmallestSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest};
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
        System.out.println("\nDigit count: " + countDigits(number));
        System.out.printf("Duck number: %s\n", isDuckNumber(number));
        System.out.printf("Armstrong number: %s\n", isArmstrongNumber(number));
        int[] largest = findLargestSecondLargest(digits);
        System.out.printf("Largest: %d, Second Largest: %d\n", largest[0], largest[1]);
        int[] smallest = findSmallestSecondSmallest(digits);
        System.out.printf("Smallest: %d, Second Smallest: %d\n", smallest[0], smallest[1]);
    }
}

