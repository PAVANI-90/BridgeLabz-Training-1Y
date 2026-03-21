package com.gla.ExceptionHandling.finallyBlockExecution;

import java.util.Scanner;

public class DivisionFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int num = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denom = scanner.nextInt();
        scanner.close();

        try {
            int result = num / denom;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error!");
        } finally {
            System.out.println("Operation completed");
        }
    }
}