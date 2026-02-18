package com.gla.methods.Level2;
import java.util.Scanner;

public class UnitConvertorFarhenheitToCelsius {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Temperature & Weight/Volume Converter ===");
        System.out.println("1. °F → °C");
        System.out.println("2. °C → °F");
        System.out.println("3. pounds → kg");
        System.out.println("4. kg → pounds");
        System.out.println("5. gallons → liters");
        System.out.println("6. liters → gallons");
        System.out.print("\nEnter choice (1-6): ");
        int choice = sc.nextInt();
        double input, result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter Fahrenheit: ");
                input = sc.nextDouble();
                result = convertFahrenheitToCelsius(input);
                System.out.printf("%.2f°F = %.2f°C\n", input, result);
                break;
            case 2:
                System.out.print("Enter Celsius: ");
                input = sc.nextDouble();
                result = convertCelsiusToFahrenheit(input);
                System.out.printf("%.2f°C = %.2f°F\n", input, result);
                break;
            case 3:
                System.out.print("Enter pounds: ");
                input = sc.nextDouble();
                result = convertPoundsToKilograms(input);
                System.out.printf("%.2f lb = %.2f kg\n", input, result);
                break;
            case 4:
                System.out.print("Enter kilograms: ");
                input = sc.nextDouble();
                result = convertKilogramsToPounds(input);
                System.out.printf("%.2f kg = %.2f lb\n", input, result);
                break;
            case 5:
                System.out.print("Enter gallons: ");
                input = sc.nextDouble();
                result = convertGallonsToLiters(input);
                System.out.printf("%.2f gal = %.2f L\n", input, result);
                break;
            case 6:
                System.out.print("Enter liters: ");
                input = sc.nextDouble();
                result = convertLitersToGallons(input);
                System.out.printf("%.2f L = %.2f gal\n", input, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}

