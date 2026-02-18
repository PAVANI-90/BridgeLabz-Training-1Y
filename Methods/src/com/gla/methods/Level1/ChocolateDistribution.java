package com.gla.methods.Level1;
import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        int perChild = chocolates / children;
        int remaining = chocolates % children;
        return new int[]{perChild, remaining};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        System.out.printf("\nEach child gets %d chocolates\n", result[0]);
        System.out.printf("%d chocolates remaining\n", result[1]);
        System.out.printf("Verification: %d × %d + %d = %d chocolates ✓\n",
                result[0], numberOfChildren, result[1], numberOfChocolates);

        sc.close();
    }
}
