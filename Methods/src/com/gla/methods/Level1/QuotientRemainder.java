package com.gla.methods.Level1;

import java.util.Scanner;

public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dividend (number): ");
        int number = sc.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();
        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.printf("%d ÷ %d = Quotient: %d, Remainder: %d\n",
                number, divisor, result[0], result[1]);
        System.out.printf("Verification: %d × %d + %d = %d ✓\n",
                result[0], divisor, result[1], number);

        sc.close();
    }
}

