package com.gla.GenericsAndCollections.Generics;
import java.util.*;
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super("Dog: " + name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super("Cat: " + name);
    }
}

public class AnimalHierarchy {
    public static void printAnimals(List<? extends Animal> animals) {
        System.out.println("Animals:");
        for (Animal a : animals) {
            System.out.println("  " + a);
        }
    }
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog("Buddy"), new Dog("Max"));
        List<Cat> cats = Arrays.asList(new Cat("Whiskers"), new Cat("Luna"));

        printAnimals(dogs);
        printAnimals(cats);
    }
}
