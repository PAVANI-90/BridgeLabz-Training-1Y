package com.gla.encapsulation.Level1;
import java.util.*;

// Discountable interface
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract FoodItem class with encapsulation
abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;
    protected double discountRate = 0.0;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: getters/setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getDiscountRate() { return discountRate; }

    // Abstract total price calculation
    public abstract double calculateTotalPrice();

    // Concrete details method
    public void getItemDetails() {
        double total = calculateTotalPrice();
        System.out.printf("%s (Qty: %d) - Unit: $%.2f, Total: $%.2f (Discount: %.0f%%)%n",
                itemName, quantity, price, total, discountRate * 100);
    }
}

// VegItem subclass (discountable)
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity) * (1 - getDiscountRate());
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 1) {
            this.discountRate = percentage;
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Veg combo discount: " + (discountRate * 100) + "%";
    }
}

// NonVegItem subclass (discountable, extra charges)
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_CHARGE = 1.15;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double base = price * NON_VEG_CHARGE * quantity;
        return base * (1 - getDiscountRate());
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 0.20) {
            this.discountRate = percentage;
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Non-veg limited discount: " + (discountRate * 100) + "% + 15% surcharge";
    }
}

// Main class - polymorphism & order processing
public class OnlineFoodDeliverySystem {
    // Polymorphic order processing method
    public static void processOrder(List<FoodItem> order) {
        double grandTotal = 0;
        for (FoodItem item : order) {
            item.getItemDetails();
            grandTotal += item.calculateTotalPrice();
        }
        System.out.printf("%nOrder Grand Total: $%.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        // Order as List<FoodItem>
        List<FoodItem> order = new ArrayList<>();

        VegItem salad = new VegItem("Veg Salad", 8.99, 2);
        NonVegItem chicken = new NonVegItem("Grilled Chicken", 15.99, 1);
        VegItem rice = new VegItem("Veg Fried Rice", 12.99, 1);
        NonVegItem burger = new NonVegItem("Chicken Burger", 10.99, 2);

        order.add(salad);
        order.add(chicken);
        order.add(rice);
        order.add(burger);

        System.out.println(" Online Food Delivery System \n");

        // Demo discounts (polymorphic instanceof check)
        System.out.println("Before Discounts");
        processOrder(order);

        // Apply discounts
        if (salad instanceof Discountable) ((Discountable) salad).applyDiscount(0.10);     // 10%
        if (chicken instanceof Discountable) ((Discountable) chicken).applyDiscount(0.15); // 15%
        if (rice instanceof Discountable) ((Discountable) rice).applyDiscount(0.10);
        if (burger instanceof Discountable) ((Discountable) burger).applyDiscount(0.10);

        System.out.println("\n--- After Discounts ---");
        processOrder(order);
    }
}

