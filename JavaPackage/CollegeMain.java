package com.gla.JavaPackage;

public class CollegeMain {
    public static void main(String[] args) {

        Student2 student = new Student2(" Jyoti Choudhary ");

        Facultyname faculty = new Facultyname(" Dr. Mehta ");

        Department department = new Department("Computer Science");

        System.out.println("----- College Information -----");

        student.display();
        faculty.display();
        department.display();
    }

}

