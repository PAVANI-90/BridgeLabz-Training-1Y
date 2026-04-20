package com.gla.StreamAPI.LambdaExpressions;
import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    double price, rating, discount;

    Product(String n, double p, double r, double d) {
        name = n; price = p; rating = r; discount = d;
    }

    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public double getDiscount() { return discount; }

    public String toString() {
        return name + " (P:" + price + ", R:" + rating + ", D:" + discount + ")";
    }
}

public class ECommerceSort {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000, 4.5, 10),
                new Product("Phone", 800, 4.8, 20),
                new Product("Tablet", 500, 4.2, 15)
        );

        System.out.println("By price:");
        products.stream()
                .sorted(Comparator.comparing(p -> p.getPrice()))  // Works with lambda too
                .forEach(System.out::println);

        System.out.println("\nBy rating:");
        products.stream()
                .sorted(Comparator.comparing(Product::getRating).reversed())
                .forEach(System.out::println);

        System.out.println("\nBy discount:");
        List<Product> sorted = products.stream()
                .sorted(Comparator.comparing(Product::getDiscount))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

}

