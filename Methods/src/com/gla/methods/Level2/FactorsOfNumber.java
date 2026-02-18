package com.gla.methods.Level2;
import java.util.Scanner;

public class FactorsOfNumber {
    public static int[] getFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }
    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }
    public static long productFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
    public static double sumSquareFactors(int[] factors) {
        double sumSquares = 0;
        for (int factor : factors) {
            sumSquares += Math.pow(factor, 2);
        }
        return sumSquares;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] factors = getFactors(number);
        System.out.printf("\nFactors of %d: ", number);
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
        System.out.printf("Sum of factors: %d\n", sumFactors(factors));
        System.out.printf("Product of factors: %d\n", productFactors(factors));
        System.out.printf("Sum of squares of factors: %.0f\n", sumSquareFactors(factors));
        sc.close();
    }
}
