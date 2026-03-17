package com.gla.Javapackage;

public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String toString() {
        return id + " " + name + " " + department + " Salary: " + salary;
    }

}
