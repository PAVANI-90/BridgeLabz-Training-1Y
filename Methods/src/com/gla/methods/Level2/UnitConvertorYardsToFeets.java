package com.gla.methods.Level2;
import java.util.Scanner;

public class UnitConvertorYardsToFeets {
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Extended Unit Converter ===");
        System.out.println("1. yards → feet");
        System.out.println("2. feet → yards");
        System.out.println("3. meters → inches");
        System.out.println("4. inches → meters");
        System.out.println("5. inches → cm");
        System.out.print("\nEnter choice (1-5): ");
        int choice = sc.nextInt();
        double input, result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter yards: ");
                input = sc.nextDouble();
                result = convertYardsToFeet(input);
                System.out.printf("%.2f yards = %.2f feet\n", input, result);
                break;
            case 2:
                System.out.print("Enter feet: ");
                input = sc.nextDouble();
                result = convertFeetToYards(input);
                System.out.printf("%.2f feet = %.2f yards\n", input, result);
                break;
            case 3:
                System.out.print("Enter meters: ");
                input = sc.nextDouble();
                result = convertMetersToInches(input);
                System.out.printf("%.2f meters = %.2f inches\n", input, result);
                break;
            case 4:
                System.out.print("Enter inches: ");
                input = sc.nextDouble();
                result = convertInchesToMeters(input);
                System.out.printf("%.2f inches = %.2f meters\n", input, result);
                break;
            case 5:
                System.out.print("Enter inches: ");
                input = sc.nextDouble();
                result = convertInchesToCm(input);
                System.out.printf("%.2f inches = %.2f cm\n", input, result);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}

