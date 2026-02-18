package com.gla.methods.Level2;
import java.util.Scanner;

public class BodyMassIndex {
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }
    public static String getStatus(double bmi) {
        if (bmi <= 18.4)
            return "Underweight";
        else if (bmi <= 24.9)
            return "Normal";
        else if (bmi <= 39.9)
            return "Overweight";
        else
            return "Obese";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double data[][] = new double[10][3];
        String status[] = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            status[i] = getStatus(data[i][2]);
        }
        System.out.println("\nWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.1f\t%.1f\t%.2f\t%s\n",
                    data[i][0], data[i][1], data[i][2], status[i]);
        }
        sc.close();
    }
}
