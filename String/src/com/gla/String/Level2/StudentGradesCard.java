package com.gla.String.Level2;
import java.util.Random;

public class StudentGradesCard {
    public static int[][] generateScores(int students) {
        Random r = new Random();
        int[][] scores = new int[students][3]; // PCM

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + r.nextInt(90); // 2-digit (10–99)
            }
        }
        return scores;
    }
    public static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] result = new double[n][3]; // total, average, percentage

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            percentage = Math.round(percentage * 100.0) / 100.0; // round 2 digits

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }
    public static String calculateGrade(double percentage) {

        if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else if (percentage >= 40)
            return "E";
        else
            return "R";
    }
    public static void display(int[][] scores, double[][] result) {

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPercent\tGrade");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {

            String grade = calculateGrade(result[i][2]);

            System.out.println(
                    (i + 1) + "\t" +
                            scores[i][0] + "\t" +
                            scores[i][1] + "\t" +
                            scores[i][2] + "\t" +
                            (int) result[i][0] + "\t" +
                            String.format("%.2f", result[i][1]) + "\t" +
                            String.format("%.2f", result[i][2]) + "\t\t" +
                            grade
            );
        }
    }

    public static void main(String[] args) {

        int students = 5;

        int[][] scores = generateScores(students);
        double[][] result = calculateResults(scores);

        display(scores, result);
    }
}