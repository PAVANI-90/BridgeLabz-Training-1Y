package com.gla.ClassesObjects.Level1;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person p) {
        name = p.name;
        age = p.age;
    }

    void display() {
        System.out.println(name);
        System.out.println(age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Anushka", 20);
        Person p2 = new Person(p1);
        p1.display();
        p2.display();
    }


}

