package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class CourseRegistrationSystem {
    private Map<String, Integer> courseRegistrations;

    public CourseRegistrationSystem() {
        this.courseRegistrations = new HashMap<>();
    }

    public void addCourse(String courseCode, int initialCount) {
        courseRegistrations.put(courseCode, Math.max(initialCount, 0));
    }

    public void addStudent(String courseCode) {
        int current = courseRegistrations.getOrDefault(courseCode, 0);
        courseRegistrations.put(courseCode, current + 1);
    }

    public void dropStudent(String courseCode) {
        Integer current = courseRegistrations.get(courseCode);
        if (current == null) return;
        int newCount = current - 1;
        if (newCount < 0) newCount = 0;
        courseRegistrations.put(courseCode, newCount);
    }

    public void printStatus(int nearFullThreshold, int underSubscribedThreshold) {
        System.out.println("\nCourse registrations:");
        for (Map.Entry<String, Integer> e : courseRegistrations.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        System.out.println("\nNear full (≥ " + nearFullThreshold + "):");
        for (Map.Entry<String, Integer> e : courseRegistrations.entrySet()) {
            if (e.getValue() >= nearFullThreshold) {
                System.out.println("  " + e.getKey() + " -> " + e.getValue());
            }
        }

        System.out.println("\nUnder-subscribed (< " + underSubscribedThreshold + "):");
        for (Map.Entry<String, Integer> e : courseRegistrations.entrySet()) {
            if (e.getValue() < underSubscribedThreshold) {
                System.out.println("  " + e.getKey() + " -> " + e.getValue());
            }
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        system.addCourse("CS101", 45);
        system.addCourse("CS102", 3);
        system.addCourse("MA101", 52);
        system.addCourse("PH101", 0);
        system.addCourse("EE101", 10);

        system.addStudent("CS101");
        system.addStudent("CS101");
        system.addStudent("CS102");
        system.addStudent("PH101");
        system.addStudent("PH101");
        system.addStudent("MA101");

        system.dropStudent("EE101");
        system.dropStudent("CS102");
        system.dropStudent("CS102");

        system.printStatus(50, 5);
    }
}
