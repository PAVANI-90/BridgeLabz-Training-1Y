package com.gla.StreamAPI.LambdaExpressions.MethodReferences;
import java.util.*;

class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name;
    }
}
public class HospitalPatientPrinting {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient(101, "John Doe"),
                new Patient(102, "Jane Smith"),
                new Patient(103, "Bob Johnson"),
                new Patient(104, "Alice Brown")
        );

        System.out.println(" All Patient Details ");

        patients.forEach(System.out::println);

        System.out.println("\n Patient IDs Only ");

        patients.stream()
                .map(Patient::getId)
                .forEach(System.out::println);

        System.out.println("\n=== IDs in Sorted Order ===");

        patients.stream()
                .mapToInt(Patient::getId)
                .sorted()
                .forEach(System.out::println);
    }
}
