package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Order {
    private String orderId;
    private String customerName;
    private double amount;

    public Order(String orderId, String customerName, double amount) {
        this.orderId      = orderId;
        this.customerName = customerName;
        this.amount       = amount;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order o2 = (Order) o;
        return orderId.equals(o2.orderId);
    }

    @Override
    public int hashCode() {
        return orderId.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Order{#%s, %s, ₹%.2f}", orderId, customerName, amount);
    }
}

public class OrderProcessingSystem {
    private List<Order> allOrders;
    private Set<Order> uniqueOrders;
    private Queue<Order> ordersToProcess;
    private Stack<Order> failedOrders;

    public OrderProcessingSystem() {
        this.allOrders        = new ArrayList<>();
        this.uniqueOrders     = new HashSet<>();
        this.ordersToProcess  = new LinkedList<>();
        this.failedOrders     = new Stack<>();
    }

    public void addOrder(Order order) {
        allOrders.add(order);

        if (uniqueOrders.add(order)) {
            ordersToProcess.add(order);
        }
    }

    public void processAllOrders() {
        System.out.println("\nProcessing valid orders (FIFO) ");
        while (!ordersToProcess.isEmpty()) {
            Order order = ordersToProcess.poll();
            boolean success = processOrder(order);
            if (!success) {
                failedOrders.push(order);
            }
        }
    }

    private boolean processOrder(Order order) {
        System.out.println("Processing: " + order);

        boolean success = order.getAmount() < 1000 || Math.random() > 0.5;
        if (success) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
        return success;
    }

    public void retryFailedOrders() {
        System.out.println("\n Re-processing failed orders (LIFO) ");
        while (!failedOrders.isEmpty()) {
            Order order = failedOrders.pop();
            System.out.println("Retrying: " + order);
            boolean success = processOrder(order);
            if (!success) {
                System.err.println("   Still failed; marking as permanently failed.");
            }
        }
    }


    public void printSummary() {
        System.out.println("\n System Summary ");
        System.out.println("Total placed orders (with duplicates): " + allOrders.size());
        System.out.println("Unique orders (no duplicates)        : " + uniqueOrders.size());
        System.out.println("Pending orders                       : " + ordersToProcess.size());
        System.out.println("Failed (retry stack)                 : " + failedOrders.size());
    }


    public static void main(String[] args) {
        OrderProcessingSystem system = new OrderProcessingSystem();


        system.addOrder(new Order("ORD001", "Rahul", 500.0));
        system.addOrder(new Order("ORD002", "Priya", 2500.0));
        system.addOrder(new Order("ORD001", "Rahul", 500.0));
        system.addOrder(new Order("ORD003", "Vikas", 800.0));
        system.addOrder(new Order("ORD004", "Aisha", 1200.0));

        system.printSummary();




        system.processAllOrders();


        system.retryFailedOrders();

        system.printSummary();
    }
}
