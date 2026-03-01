package com.gla.encapsulation.Level1;

import java.util.*;

// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class with encapsulation
abstract class Product {
    private int productId;
    private String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Abstract discount method
    public abstract double calculateDiscount();

    public void printFinalPrice() {
        double discount = calculateDiscount();
        double tax = 0;
        if (this instanceof Taxable) {
            tax = ((Taxable) this).calculateTax();
        }
        double finalPrice = price + tax - discount;
        System.out.printf("Product ID: %d, %s - Final Price: $%.2f (Discount: $%.2f, Tax: $%.2f)%n",
                productId, name, finalPrice, discount, tax);
    }
}
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public double calculateTax() {
        return price * 0.08;
    }

    @Override
    public String getTaxDetails() {
        return "8% sales tax on electronics";
    }
}
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.15;
    }

    @Override
    public double calculateTax() {
        return price * 0.06;
    }

    @Override
    public String getTaxDetails() {
        return "6% sales tax on clothing";
    }
}
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05;
    }
}

// Main class - polymorphism demo
public class ECommercePlatform {
    public static void main(String[] args) {
        // List of Product references
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "iPhone 15", 999.99));
        products.add(new Clothing(2, "Designer Shirt", 89.99));
        products.add(new Groceries(3, "Organic Apples", 4.99));
        products.add(new Electronics(4, "Laptop Dell", 1299.99));
        products.add(new Clothing(5, "Jeans Levi's", 59.99));

        System.out.println(" E-Commerce Platform - Final Prices\n");

        // Polymorphic processing: calls correct subclass methods
        for (Product p : products) {
            p.printFinalPrice();
        }
    }
}

