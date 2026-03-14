package com.gla.ClassesObjects.Level1;

public class Circle1 {
    double radius;

    Circle1() {
        this(1.0);
    }

    Circle1(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println(radius);
        System.out.println(Math.PI * radius * radius);
    }

    public static void main(String[] args) {
        Circle1 c1 = new Circle1();
        Circle1 c2 = new Circle1(5);
        c1.display();
        c2.display();
    }

}

