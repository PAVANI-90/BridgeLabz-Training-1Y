package com.gla.methods.Level3;
import java.util.Scanner;
public class EuclideanDistance {
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            return new double[]{Double.NaN, Double.NaN};
        }
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter point 1 (x1 y1): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("Enter point 2 (x2 y2): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double distance = calculateDistance(x1, y1, x2, y2);
        double[] line = lineEquation(x1, y1, x2, y2);
        double m = line[0];
        double b = line[1];
        System.out.printf("\nPoints: (%.2f, %.2f) and (%.2f, %.2f)\n", x1, y1, x2, y2);
        System.out.printf("Euclidean Distance: %.3f\n", distance);
        if (Double.isNaN(m)) {
            System.out.println("Line Equation: x = " + x1 + " (Vertical line)");
        } else {
            System.out.printf("Line Equation: y = %.3fx + %.3f\n", m, b);
            System.out.printf("Slope (m): %.3f\n", m);
            System.out.printf("Y-intercept (b): %.3f\n", b);
        }
        sc.close();
    }
}

