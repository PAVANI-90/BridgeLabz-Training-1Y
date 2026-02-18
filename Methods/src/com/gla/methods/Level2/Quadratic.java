package com.gla.methods.Level2;
import java.util.Scanner;
public class Quadratic {
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[0];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        double[] roots = findRoots(a, b, c);
        System.out.printf("\nEquation: %.1fx² + %.1fx + %.1f = 0\n", a, b, c);
        if (roots.length == 2) {
            System.out.printf("Two real roots:\n");
            System.out.printf("root1 = %.3f\n", roots[0]);
            System.out.printf("root2 = %.3f\n", roots[1]);
        } else if (roots.length == 1) {
            System.out.printf("One real root (repeated):\n");
            System.out.printf("root = %.3f\n", roots[0]);
        } else {
            System.out.println("No real roots (complex roots)");
        }
        sc.close();
    }
}

