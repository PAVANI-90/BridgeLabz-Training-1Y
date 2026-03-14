package com.gla.ClassesObjects.Level1;

public class Employee {
    String name;
    int id;
    double salary;

    void setDetails(String n, int i, double s) {
        name = n;
        id = i;
        salary = s;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setDetails("Anushka", 101, 50000);
        e.displayDetails();
    }


}

