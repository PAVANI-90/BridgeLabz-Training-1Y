package com.gla.methods.Level2;
import java.util.Scanner;
public class NaturalSumRecursive {
    public static long recursiveSum(int n) {
        if (n <= 1) {
            return n;
        }
        return n + recursiveSum(n - 1);
    }
    public static long formulaSum(int n) {
        return (long) n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number (n ≥ 1): ");
        int n;
        while (true) {
            n = sc.nextInt();
            if (n >= 1) {
                break;
            }
            System.out.print("Please enter n ≥ 1: ");
        }
        long recursiveResult = recursiveSum(n);
        long formulaResult = formulaSum(n);
        System.out.printf("\nSum of first %d natural numbers:\n", n);
        System.out.printf("Recursive: %d\n", recursiveResult);
        System.out.printf("Formula: %d\n", formulaResult);
        if (recursiveResult == formulaResult) {
            System.out.println(" Both methods give IDENTICAL results!");
        } else {
            System.out.println("Results don't match!");
        }

        sc.close();
    }
}
