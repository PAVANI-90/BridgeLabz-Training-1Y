package com.gla.encapsulation.Level1;

import java.util.ArrayList;
import java.util.List;

// Department interface
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// Abstract Employee class with encapsulation
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    protected double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and setters for encapsulation
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + getEmployeeId() +
                ", Name: " + getName() +
                ", Salary: $" + calculateSalary());
    }

    @Override
    public void assignDepartment(String dept) {
        // Default implementation
    }

    @Override
    public String getDepartmentDetails() {
        return "No department assigned";
    }
}

// FullTimeEmployee subclass
class FullTimeEmployee extends Employee {
    private double hourlyRate;
    private int weeklyHours = 40;

    public FullTimeEmployee(int employeeId, String name, double hourlyRate) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * weeklyHours * 52;
    }
}

// PartTimeEmployee subclass
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int monthlyHours;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int monthlyHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.monthlyHours = monthlyHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * monthlyHours * 12;
    }
}

// Main class demonstrating polymorphism
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        //  (polymorphism)
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(1, "John Doe", 30.0));
        employees.add(new PartTimeEmployee(2, "Jane Smith", 20.0, 80));
        employees.add(new FullTimeEmployee(3, "Bob Johnson", 35.0));
        employees.add(new PartTimeEmployee(4, "Alice Brown", 18.0, 60));

        System.out.println(" Employee Management System : ");
        System.out.println("Displaying details using Employee polymorphism:\n");

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: " + emp.getDepartmentDetails() + "\n");
        }
    }
}

