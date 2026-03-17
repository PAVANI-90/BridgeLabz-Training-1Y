package com.gla.JavaPackage;


public class LearnerTest {


    public static void main(String[] args) {

        // Create a Learner object
        Learner l = new Learner("Alice", 85, 92, 78);

        // Calculate average and grade using Analyzer
        double avg = Analyzer.calculateAverage(l);
        String grade = Analyzer.findGrade(avg);

        // Print details
        System.out.println(l);          // uses Learner.toString()
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
    }

}
