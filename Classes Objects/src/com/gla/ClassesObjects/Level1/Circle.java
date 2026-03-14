package com.gla.ClassesObjects.Level1;

public class Circle {
    double radius;

    void setRadius(double r) {
        radius = r;
    }

    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area: " + area);
    }

    void calculateCircumference() {
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference: " + circumference);
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(5);
        c.calculateArea();
        c.calculateCircumference();
    }
}
