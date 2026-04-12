package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class ShoppingCartSystem {
    private LinkedHashMap<String, Double> cart;
    private Map<String, Integer> quantities;

    public ShoppingCartSystem() {
        this.cart = new LinkedHashMap<>();
        this.quantities = new HashMap<>();
    }

    public void addProduct(String name, double price, int qty) {
        cart.put(name, price);
        quantities.put(name, quantities.getOrDefault(name, 0) + qty);
        if (quantities.get(name) <= 0) {
            cart.remove(name);
            quantities.remove(name);
        }
    }

    public void removeProductQuantity(String name, int qty) {
        if (!quantities.containsKey(name)) {
            System.out.println("Product not in cart: " + name);
            return;
        }
        int newQty = quantities.get(name) - qty;
        if (newQty <= 0) {
            quantities.remove(name);
            cart.remove(name);
            System.out.println("Removed product from cart: " + name);
        } else {
            quantities.put(name, newQty);
            System.out.println("Updated quantity for " + name + ": " + newQty);
        }
    }

    public void displayCart() {
        System.out.println("\nProducts in cart (in order of addition):");
        for (Map.Entry<String, Double> e : cart.entrySet()) {
            String name = e.getKey();
            double price = e.getValue();
            int qty = quantities.getOrDefault(name, 0);
            System.out.println(name + " - price: " + price + ", qty: " + qty);
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<String, Double> e : cart.entrySet()) {
            String name = e.getKey();
            double price = e.getValue();
            int qty = quantities.getOrDefault(name, 0);
            total += price * qty;
        }
        return total;
    }

    public double calculateTotalWithDiscount() {
        double total = calculateTotal();
        if (total > 5000.0) {
            System.out.println("Applying 10% discount on total: " + total);
            total = total * 0.9;
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCartSystem cart = new ShoppingCartSystem();

        cart.addProduct("Laptop", 40000.0, 1);
        cart.addProduct("Mouse", 500.0, 2);
        cart.addProduct("Keyboard", 1500.0, 1);
        cart.addProduct("USB Cable", 200.0, 3);

        cart.displayCart();

        cart.removeProductQuantity("USB Cable", 3);
        cart.removeProductQuantity("Mouse", 1);

        cart.displayCart();

        double total = cart.calculateTotal();
        System.out.println("\nTotal before discount: " + total);

        double finalAmount = cart.calculateTotalWithDiscount();
        System.out.println("Final amount to pay: " + finalAmount);
    }
}
