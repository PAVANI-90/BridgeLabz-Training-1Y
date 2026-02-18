package com.gla.methods.Level1;
import java.util.Scanner;

public class NaturalNumSum {
    public static long sumNaturalNumbers(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        long totalSum = sumNaturalNumbers(n);

        System.out.printf("Sum of first %d natural numbers = %d\n", n, totalSum);
        System.out.printf("Formula verification: n(n+1)/2 = %d(%d+1)/2 = %d ✓\n",
                n, n, n * (n + 1) / 2);

        sc.close();
    }
}

