package com.gla.methods.Level2;
import java.util.Scanner;

public class UnitConvertor {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Unit Converter ===");
        System.out.println("1. km → miles");
        System.out.println("2. miles → km");
        System.out.println("3. meters → feet");
        System.out.println("4. feet → meters");
        System.out.print("\nEnter choice (1-4): ");
        int choice = sc.nextInt();
        double input, result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter km: ");
                input = sc.nextDouble();
                result = convertKmToMiles(input);
                System.out.printf("%.2f km = %.2f miles\n", input, result);
                break;
            case 2:
                System.out.print("Enter miles: ");
                input = sc.nextDouble();
                result = convertMilesToKm(input);
                System.out.printf("%.2f miles = %.2f km\n", input, result);
                break;
            case 3:
                System.out.print("Enter meters: ");
                input = sc.nextDouble();
                result = convertMetersToFeet(input);
                System.out.printf("%.2f meters = %.2f feet\n", input, result);
                break;
            case 4:
                System.out.print("Enter feet: ");
                input = sc.nextDouble();
                result = convertFeetToMeters(input);
                System.out.printf("%.2f feet = %.2f meters\n", input, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}

