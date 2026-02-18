package com.gla.methods.Level3;
import java.util.Scanner;
import java.util.Random;
public class StudentScore {
    static int[][] generateMarks(int n) {
        Random r = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = 10 + r.nextInt(90);
            }
        }
        return marks;
    }
    static double[][] calculateResult(int[][] marks) {
        int n = marks.length;
        double[][] result = new double[n][3];
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }
    static void display(int[][] marks, double[][] result) {
        System.out.println("\nRoll\tPhy\tChem\tMath\tTotal\tAvg\tPercent");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n",
                    (i+1),
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    result[i][0],
                    result[i][1],
                    result[i][2]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = generateMarks(n);
        double[][] result = calculateResult(marks);
        display(marks, result);
        sc.close();
    }
}