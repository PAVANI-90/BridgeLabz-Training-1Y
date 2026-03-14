package com.gla.ClassesObjects.Level1;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    int costPerDay = 1000;

    CarRental() {
        customerName = "Customer";
        carModel = "Basic";
        rentalDays = 1;
    }

    CarRental(String name, String model, int days) {
        customerName = name;
        carModel = model;
        rentalDays = days;
    }

    int calculateCost() {
        return rentalDays * costPerDay;
    }

    void display() {
        System.out.println(customerName);
        System.out.println(carModel);
        System.out.println(rentalDays);
        System.out.println(calculateCost());
    }

    public static void main(String[] args) {
        CarRental c = new CarRental("Anushka", "Swift", 3);
        c.display();
    }
}