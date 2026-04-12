package com.gla.GenericsAndCollections.Generics;
import java.util.*;
abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}

class Mobile extends Product {
    public Mobile(String name, double price) {
        super(name, price);
    }
}

class Laptop extends Product {
    public Laptop(String name, double price) {
        super(name, price);
    }
}
public class PriceCalculator {
    public static double calculateTotal(List<? extends Product> items) {
        double total = 0.0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }
    public static void main(String[] args) {
        List<Mobile> mobiles = Arrays.asList(
                new Mobile("iPhone 15", 79990),
                new Mobile("Samsung Galaxy", 54990)
        );

        List<Laptop> laptops = Arrays.asList(
                new Laptop("MacBook Air", 99900),
                new Laptop("Dell Inspiron", 56990)
        );

        System.out.println("Mobiles: " + mobiles);
        System.out.println("Total mobile price: ₹" + calculateTotal(mobiles));

        System.out.println("Laptops: " + laptops);
        System.out.println("Total laptop price: ₹" + calculateTotal(laptops));
    }
}
