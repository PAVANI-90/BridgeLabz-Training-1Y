package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class EmployeeSalaryDirectory {
    private Map<String, Double> salaries;

    public EmployeeSalaryDirectory() {
        this.salaries = new HashMap<>();
    }

    public void addEmployee(String name, double salary) {
        salaries.put(name, salary);
    }

    public void giveRaise(String name, double percent) {
        Double current = salaries.get(name);
        if (current == null) {
            System.out.println("Employee not found: " + name);
            return;
        }
        double newSalary = current + current * (percent / 100.0);
        salaries.put(name, newSalary);
        System.out.println("New salary for " + name + ": " + newSalary);
    }

    public double averageSalary() {
        if (salaries.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double s : salaries.values()) {
            sum += s;
        }
        return sum / salaries.size();
    }

    public List<String> highestPaidEmployees() {
        List<String> result = new ArrayList<>();
        double max = Double.NEGATIVE_INFINITY;
        for (Map.Entry<String, Double> e : salaries.entrySet()) {
            double sal = e.getValue();
            if (sal > max) {
                max = sal;
            }
        }
        for (Map.Entry<String, Double> e : salaries.entrySet()) {
            if (e.getValue() == max) {
                result.add(e.getKey());
            }
        }
        return result;
    }

    public void printAll() {
        System.out.println("\nAll employees and salaries:");
        for (Map.Entry<String, Double> e : salaries.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public static void main(String[] args) {
        EmployeeSalaryDirectory dir = new EmployeeSalaryDirectory();

        dir.addEmployee("Amit", 50000);
        dir.addEmployee("Priya", 65000);
        dir.addEmployee("Rahul", 48000);
        dir.addEmployee("Sneha", 72000);
        dir.addEmployee("Vikas", 55000);
        dir.addEmployee("Anita", 72000);

        dir.printAll();

        dir.giveRaise("Amit", 10);
        dir.giveRaise("Rahul", 5);
        dir.giveRaise("Unknown", 5);

        dir.printAll();

        double avg = dir.averageSalary();
        System.out.println("\nAverage salary: " + avg);

        List<String> highest = dir.highestPaidEmployees();
        System.out.println("Highest paid employee(s): " + highest);
    }
}
