package com.gla.StoryBased;

abstract class Order {
    protected int orderId;
    protected double baseAmount;

    public Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }


    public abstract double calculateBill();

    public static final double deliveryCharge = 40.0;
}


class RegularOrder extends Order {
    public RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}


class PremiumOrder extends Order {
    public PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        double discounted = baseAmount * 0.8;
        return discounted + deliveryCharge;
    }
}

public class FoodOrderDemo {
    public static void main(String[] args) {
        // Polymorphic array
        Order[] orders = {
                new RegularOrder(101, 200.0),
                new PremiumOrder(102, 300.0),
                new RegularOrder(103, 150.0)
        };

        for (Order order : orders) {
            System.out.println("Order " + order.orderId + " Bill: $" +
                    String.format("%.2f", order.calculateBill()));
        }
    }
}
