package com.gla.StreamAPI.LambdaExpressions.MethodReferences;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
public class HREmployeeNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("john doe", 101),
                new Employee("jane smith", 102),
                new Employee("bob johnson", 103),
                new Employee("alice brown", 104)
        );

        System.out.println("=== Original Names ===");
        employees.forEach(System.out::println);

        System.out.println("\n=== UPPERCASE for HR Letter ===");

        List<String> upperNames = employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperNames.forEach(System.out::println);

        System.out.println("\n=== With Employee Context ===");

        employees.stream()
                .map(e -> new Employee(e.getName().toUpperCase(), e.id))
                .forEach(System.out::println);
    }
}
