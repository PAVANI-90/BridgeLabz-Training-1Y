package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();

        grades.put("Amit", 85.0);
        grades.put("Priya", 92.5);
        grades.put("Rahul", 76.0);
        grades.put("Sneha", 88.0);

        grades.put("Rahul", 81.0);
        grades.put("Amit", 90.0);

        grades.remove("Sneha");

        Map<String, Double> sorted = new TreeMap<>(grades);

        System.out.println("Students and grades (alphabetical):");
        for (Map.Entry<String, Double> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
