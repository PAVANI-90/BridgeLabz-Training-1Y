package com.gla.StreamAPI.LambdaExpressions;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Predicate;

class Alert {
    String type;
    int priority;
    Alert(String t, int p) { type = t; priority = p; }
    public String toString() { return type + " (Priority: " + priority + ")"; }
}
public class HospitalNotifications {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("EMERGENCY", 9),
                new Alert("Routine", 3),
                new Alert("URGENT", 8),
                new Alert("Info", 2)
        );

        System.out.println("High priority:");
        alerts.stream()
                .filter(a -> a.priority > 7)
                .forEach(System.out::println);

        System.out.println("\nEmergencies:");
        alerts.stream()
                .filter(a -> "EMERGENCY".equals(a.type))
                .forEach(System.out::println);

        Predicate<Alert> highPri = a -> a.priority > 7;
        Predicate<Alert> emergency = a -> "EMERGENCY".equals(a.type);
        System.out.println("\nUrgent emergencies:");
        List<Alert> filtered = alerts.stream()
                .filter(highPri.and(emergency))
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }
}
