package com.gla.JavaPackage;

public class Analyzer {



    // Calculate average marks of a Learner
    public static double calculateAverage(Learner l) {
        return (l.getMarks1() + l.getMarks2() + l.getMarks3()) / 3.0;
    }

    // Determine grade based on average
    public static String findGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 75) return "A";
        else if (average >= 60) return "B";
        else return "C";
    }
}
