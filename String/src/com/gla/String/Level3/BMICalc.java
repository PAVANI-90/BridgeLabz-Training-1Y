package com.gla.String.Level3;
import java.util.Scanner;

public class BMICalc {
    public static double[][] getInput(int n) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[n][2]; // [height, weight]

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter Height (cm): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Weight (kg): ");
            data[i][1] = sc.nextDouble();
        }
        return data;
    }
    public static String[][] calculateBMI(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4];
        for (int i = 0; i < n; i++) {
            double heightCm = data[i][0];
            double weight = data[i][1];

            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi <= 18.4)
                status = "Underweight";
            else if (bmi <= 24.9)
                status = "Normal";
            else if (bmi <= 39.9)
                status = "Overweight";
            else
                status = "Obese";

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }
    public static void display(String[][] result) {
        System.out.println("\n---------------");
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("-------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t" +
                    result[i][3]);
        }
    }

    public static void main(String[] args) {
        int persons = 10;

        double[][] input = getInput(persons);
        String[][] bmiData = calculateBMI(input);
        display(bmiData);
    }
}
