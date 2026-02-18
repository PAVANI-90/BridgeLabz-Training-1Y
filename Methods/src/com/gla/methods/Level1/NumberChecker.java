package com.gla.methods.Level1;
import java.util.Scanner;

public class NumberChecker {
    public static int checkSign(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int result = checkSign(number);

        System.out.print(number + " is ");
        if (result > 0) {
            System.out.println("POSITIVE");
        } else if (result < 0) {
            System.out.println("NEGATIVE");
        } else {
            System.out.println("ZERO");
        }

        sc.close();
    }
}
