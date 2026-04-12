package com.gla.GenericsAndCollections.Generics;
import java.util.ArrayList;

class FleetManager<T extends Vehicle> {
    private ArrayList<T> vehicles = new ArrayList<>();

    public void addVehicle(T vehicle) {
        vehicles.add(vehicle);
    }

    public void showFleet() {
        System.out.println("Fleet:");
        for (Vehicle v : vehicles) {
            System.out.println("  " + v);
        }
    }
}
abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Truck extends Vehicle {
    public Truck(String name) {
        super("Truck: " + name);
    }
}

class Bike extends Vehicle {
    public Bike(String name) {
        super("Bike: " + name);
    }
}
public class GenericFleetManagerDemo {

    public static void main(String[] args) {


        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Big Hauler"));
        truckFleet.addVehicle(new Truck("Cargo Carrier"));
        truckFleet.showFleet();

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Mountain Rider"));
        bikeFleet.addVehicle(new Bike("City Cruiser"));
        bikeFleet.showFleet();
    }
}
