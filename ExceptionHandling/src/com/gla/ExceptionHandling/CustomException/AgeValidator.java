package com.gla.ExceptionHandling.CustomException;

import java.util.Scanner;

// Custom checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    // Method throws custom exception if age < 18
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age below 18");
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.close();

        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Age must be 18 or above");
        }
    }
}
