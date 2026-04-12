package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class StudentAttendanceTracker {
    public static void main(String[] args) {
        Map<String, Integer> attendance = new HashMap<>();

        List<String> students = Arrays.asList("Amit", "Priya", "Rahul", "Sneha", "Vikas");
        for (String s : students) {
            attendance.put(s, 0);
        }

        Random rand = new Random();
        int days = 15;

        for (int day = 1; day <= days; day++) {
            System.out.println("Day " + day + " attendance:");
            for (String s : students) {
                boolean present = rand.nextBoolean();
                if (present) {
                    attendance.put(s, attendance.get(s) + 1);
                    System.out.println("  Present: " + s);
                }
            }
        }

        int threshold = 10;
        System.out.println("\nStudents present fewer than " + threshold + " days:");
        for (Map.Entry<String, Integer> e : attendance.entrySet()) {
            if (e.getValue() < threshold) {
                System.out.println(e.getKey() + " -> " + e.getValue() + " days");
            }
        }
    }
}
