package com.gla.encapsulation.Level1;
import java.util.*;

// Insurable interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class with encapsulation
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation: getters/setters
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    // Abstract rental cost method
    public abstract double calculateRentalCost(int days);

    // Display total costs (rental + insurance)
    public void displayRentalDetails(int days) {
        double rentalCost = calculateRentalCost(days);
        double insurance = 0;
        String insDetails = "N/A";
        if (this instanceof Insurable) {
            Insurable ins = (Insurable) this;
            insurance = ins.calculateInsurance();
            insDetails = ins.getInsuranceDetails();
        }
        double totalCost = rentalCost + insurance;
        System.out.printf("%s (%s) - Rental (%dd): $%.2f, Insurance: $%.2f, Total: $%.2f%n%s%n%n",
                vehicleNumber, type, days, rentalCost, insurance, totalCost, insDetails);
    }
}

// Car subclass
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = "CAR-" + vehicleNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.20;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.12;
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + " (Comprehensive coverage)";
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = "BIKE-" + vehicleNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.08;
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + " (Third-party liability)";
    }
}

// Truck subclass
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.50;
    }
}

// Main class - polymorphism demo
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // List of Vehicle references
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("ABC123", 80.0));
        vehicles.add(new Bike("XYZ789", 30.0));
        vehicles.add(new Truck("TRK456", 150.0));
        vehicles.add(new Car("SED999", 90.0));
        vehicles.add(new Bike("MTN321", 25.0));

        int rentalDays = 5;

        System.out.println(" Vehicle Rental System (for " + rentalDays + " days) \n");

        // Polymorphic iteration
        for (Vehicle v : vehicles) {
            v.displayRentalDetails(rentalDays);
        }
    }
}

