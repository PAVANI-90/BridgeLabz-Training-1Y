package com.gla.methods.Level1;
import java.util.Scanner;

public class TriangleRunCalculator {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double targetDistance = 5000;
        return Math.ceil(targetDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 (meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter side 2 (meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 (meters): ");
        double side3 = sc.nextDouble();
        double rounds = calculateRounds(side1, side2, side3);
        System.out.printf("\nPerimeter of triangle: %.2f meters\n", side1 + side2 + side3);
        System.out.printf("Rounds needed to complete 5km: %.0f\n", rounds);

        sc.close();
    }
}
