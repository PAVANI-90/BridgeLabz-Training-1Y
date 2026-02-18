package com.gla.methods.Level3;
import java.util.Scanner;
public class FactorOfNumber {
    public static int[] findFactors(int number) {
        if (number <= 0) return new int[0];
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
                factors[index++] = i;
            }
        }
        return factors;
    }
    public static int findGreatestFactor(int[] factors) {
        if (factors.length == 0) return 0;
        return factors[factors.length - 1];  // Largest
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
    public static double productCubeFactors(int[] factors) {
        double productCubes = 1;
        for (int factor : factors) {
            productCubes *= Math.pow(factor, 3);
        }
        return productCubes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();
        sc.close();
        int[] factors = findFactors(number);
        System.out.printf("\nNumber: %d\n", number);
        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();
        System.out.printf("Greatest factor: %d\n", findGreatestFactor(factors));
        System.out.printf("Sum of factors: %d\n", sumFactors(factors));
        System.out.printf("Product of factors: %d\n", productFactors(factors));
        System.out.printf("Product of cubes: %.0f\n", productCubeFactors(factors));
    }
}

