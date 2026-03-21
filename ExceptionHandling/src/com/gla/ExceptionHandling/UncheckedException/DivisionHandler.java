package com.gla.ExceptionHandling.UncheckedException;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        System.out.print("Enter second number: ");

        try {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numbers!");
            sc.nextLine();
        } finally {
            sc.close();
        }
    }
}
