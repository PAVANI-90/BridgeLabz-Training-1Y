package com.gla.WrapperClass.ScenarioBased;
import java.util.Scanner;
public class AgeValidation {
    public static boolean isValidAdultAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput.trim());
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        String input = scanner.nextLine();

        if (isValidAdultAge(input)) {
            System.out.println("Access granted - Welcome!");
        } else {
            System.out.println("Invalid age or under 18 - Access denied.");
        }
        scanner.close();
    }
}