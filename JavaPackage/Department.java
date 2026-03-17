package com.gla.JavaPackage;

public class Department {
    String deptName;

    public Department(String name) {
        deptName = name;
    }

    public void display() {
        System.out.println("Department: " + deptName);
    }

}

