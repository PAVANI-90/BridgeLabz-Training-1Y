package com.gla.methods.Level1;
import java.util.Scanner;

public class TrignometricCalculator {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        double[] results = calculateTrigonometricFunctions(angle);
        System.out.printf("\nAngle: %.2f° (%.3f rad)\n", angle, Math.toRadians(angle));
        System.out.printf("sin(%.2f°) = %.4f\n", angle, results[0]);
        System.out.printf("cos(%.2f°) = %.4f\n", angle, results[1]);
        System.out.printf("tan(%.2f°) = %.4f\n", angle, results[2]);

        sc.close();
    }
}

