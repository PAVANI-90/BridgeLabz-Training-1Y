package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class ExamResultSystem {
    private Map<String, Map<String, Integer>> subjectMarks = new HashMap<>();

    public void addMarks(String subject, String student, int marks) {
        Map<String, Integer> marksMap = subjectMarks.get(subject);
        if (marksMap == null) {
            marksMap = new HashMap<>();
            subjectMarks.put(subject, marksMap);
        }
        marksMap.put(student, marks);
    }

    public void printTopperPerSubject() {
        System.out.println("Topper per subject:");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : subjectMarks.entrySet()) {
            String subject = subjectEntry.getKey();
            Map<String, Integer> marksMap = subjectEntry.getValue();

            String topper = null;
            int maxMarks = -1;

            for (Map.Entry<String, Integer> studentEntry : marksMap.entrySet()) {
                String student = studentEntry.getKey();
                int marks = studentEntry.getValue();
                if (marks > maxMarks) {
                    maxMarks = marks;
                    topper = student;
                }
            }

            if (topper != null) {
                System.out.println(subject + " -> " + topper + " (" + maxMarks + ")");
            }
        }
    }

    public void printAveragePerSubject() {
        System.out.println("\nAverage score per subject:");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : subjectMarks.entrySet()) {
            String subject = subjectEntry.getKey();
            Map<String, Integer> marksMap = subjectEntry.getValue();

            int sum = 0;
            int count = 0;
            for (int marks : marksMap.values()) {
                sum += marks;
                count++;
            }
            double avg = count == 0 ? 0.0 : (double) sum / count;
            System.out.println(subject + " -> " + avg);
        }
    }

    public void printSubjectsWithScoreAbove90() {
        System.out.println("\nSubjects with at least one student scoring above 90:");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : subjectMarks.entrySet()) {
            String subject = subjectEntry.getKey();
            Map<String, Integer> marksMap = subjectEntry.getValue();

            boolean hasAbove90 = false;
            for (int marks : marksMap.values()) {
                if (marks > 90) {
                    hasAbove90 = true;
                    break;
                }
            }
            if (hasAbove90) {
                System.out.println(subject);
            }
        }
    }

    public void printAll() {
        System.out.println("\nAll subject -> (student -> marks):");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : subjectMarks.entrySet()) {
            String subject = subjectEntry.getKey();
            System.out.println(subject + ":");
            for (Map.Entry<String, Integer> studentEntry : subjectEntry.getValue().entrySet()) {
                System.out.println("  " + studentEntry.getKey() + " -> " + studentEntry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        ExamResultSystem system = new ExamResultSystem();

        system.addMarks("Math", "Alice", 95);
        system.addMarks("Math", "Bob", 88);
        system.addMarks("Math", "Charlie", 76);

        system.addMarks("Science", "Alice", 89);
        system.addMarks("Science", "Bob", 92);
        system.addMarks("Science", "David", 67);

        system.addMarks("English", "Charlie", 91);
        system.addMarks("English", "Bob", 72);

        system.printAll();
        system.printTopperPerSubject();
        system.printAveragePerSubject();
        system.printSubjectsWithScoreAbove90();
    }
}
