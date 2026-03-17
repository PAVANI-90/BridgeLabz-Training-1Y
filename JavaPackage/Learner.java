package com.gla.JavaPackage;

public class Learner {

    private String name;   // ⚠️ This was missing
    private int marks1, marks2, marks3;

    public Learner(String name, int m1, int m2, int m3) {
        this.name = name;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }

    public String getName() { return name; }
    public int getMarks1() { return marks1; }
    public int getMarks2() { return marks2; }
    public int getMarks3() { return marks3; }

    @Override
    public String toString() {
        return "Learner: " + name +
                ", Marks: [" + marks1 + ", " + marks2 + ", " + marks3 + "]";
    }
}
