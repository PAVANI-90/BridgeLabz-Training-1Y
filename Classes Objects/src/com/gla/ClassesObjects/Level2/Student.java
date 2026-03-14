package com.gla.ClassesObjects.Level2;

public class Student {
    String name;
    int rollNumber;
    int marks;

    void setDetails(String n, int r, int m) {
        name = n;
        rollNumber = r;
        marks = m;
    }

    char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 50) return 'C';
        else return 'F';
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.setDetails("Anushka", 1, 85);
        s.display();
    }
}

