package com.gla.GenericsAndCollections.Generics;
import java.util.ArrayList;
class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Apple extends Fruit {
    public Apple(String name) {
        super(name + " (Apple)");
    }
}

class Mango extends Fruit {
    public Mango(String name) {
        super(name + " (Mango)");
    }
}
class FruitBox<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void display() {
        System.out.println("Fruits in box:");
        for (Fruit f : fruits) {
            System.out.println("  " + f);
        }
    }
}
public class FruitStorage {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Mango> mangoBox = new FruitBox<>();

        appleBox.add(new Apple("Red Delicious"));
        appleBox.add(new Apple("Granny Smith"));

        mangoBox.add(new Mango("Alphonso"));
        mangoBox.add(new Mango("Kesar"));

        appleBox.display();
        mangoBox.display();
    }
}
