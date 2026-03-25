package com.gla.Threads;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

class FoodOrder implements Runnable {
    private int orderId;
    private String restaurant;
    private int deliveryTimeSeconds;
    private String deliveryType;
    private int priority;

    public FoodOrder(int orderId, String restaurant, int deliveryTimeSeconds, String deliveryType, int priority) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.deliveryTimeSeconds = deliveryTimeSeconds;
        this.deliveryType = deliveryType;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        long startTime = System.currentTimeMillis();
        String agent = Thread.currentThread().getName();


        System.out.printf("[%s] Agent %s: Order #%d from %s (%s, Prio:%d) - Picked up%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                agent, orderId, restaurant, deliveryType, priority);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        System.out.printf("[%s] Agent %s: Order #%d - In Transit%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), agent, orderId);

        try {
            Thread.sleep(deliveryTimeSeconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        long totalTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.printf("[%s] Agent %s: Order #%d - Delivered (Total time: %d seconds)%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                agent, orderId, totalTime);
    }
}
public class FoodDeliverySystem {
    public static void main(String[] args) {

        FoodOrder[] orders = {
                new FoodOrder(1001, "Pizza Palace", 2, "Express", Thread.MAX_PRIORITY),
                new FoodOrder(1002, "Burger King", 4, "Standard", Thread.NORM_PRIORITY),
                new FoodOrder(1003, "Taco Bell", 6, "Economy", 3),
                new FoodOrder(1004, "Sushi Spot", 3, "Express", Thread.MAX_PRIORITY),
                new FoodOrder(1005, "Noodle House", 5, "Economy", 3)
        };


        Thread[] agents = new Thread[5];
        for (int i = 0; i < 5; i++) {
            agents[i] = new Thread(orders[i], "Agent-" + (i+1));
            agents[i].start();
        }


        for (Thread agent : agents) {
            try {
                agent.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("All deliveries completed.");
    }
}
