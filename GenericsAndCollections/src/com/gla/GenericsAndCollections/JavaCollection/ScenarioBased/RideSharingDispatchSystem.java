package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Driver {
    private String id;
    private String name;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver d = (Driver) o;
        return id.equals(d.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Driver{" + id + ", " + name + "}";
    }
}

class RideRequest {
    private String requestId;
    private String pickupLocation;
    private String dropLocation;
    private int priority; // higher = more urgent / closer

    public RideRequest(String requestId, String pickupLocation,
                       String dropLocation, int priority) {
        this.requestId = requestId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.priority = priority;
    }

    public String getRequestId() { return requestId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return "RideRequest{" + requestId +
                ", " + pickupLocation + " -> " + dropLocation +
                ", priority=" + priority + "}";
    }
}

class Ride {
    private RideRequest request;
    private Driver driver;

    public Ride(RideRequest request, Driver driver) {
        this.request = request;
        this.driver  = driver;
    }

    public RideRequest getRequest() { return request; }
    public Driver getDriver() { return driver; }

    @Override
    public String toString() {
        return "Ride{" + request.getRequestId() +
                ", driver=" + driver.getName() +
                ", from=" + request.getPickupLocation() +
                ", to=" + request.getDropLocation() + "}";
    }
}
public class RideSharingDispatchSystem {
    private Queue<RideRequest> requestQueue;


    private PriorityQueue<RideRequest> priorityQueue;


    private Set<Driver> availableDrivers;


    private List<Ride> rideHistory;

    public RideSharingDispatchSystem() {
        this.requestQueue = new LinkedList<>();
        this.priorityQueue = new PriorityQueue<>(
                (r1, r2) -> Integer.compare(r2.getPriority(), r1.getPriority())
        );
        this.availableDrivers = new HashSet<>();
        this.rideHistory = new ArrayList<>();
    }


    public void addRideRequest(RideRequest request) {
        requestQueue.add(request);
        priorityQueue.add(request);
        System.out.println("New request added: " + request);
    }


    public void addDriver(Driver driver) {
        if (availableDrivers.add(driver)) {
            System.out.println("Driver available: " + driver);
        } else {
            System.out.println("Duplicate driver ignored: " + driver);
        }
    }


    public void assignNextRideFIFO() {
        if (requestQueue.isEmpty()) {
            System.out.println("No pending ride requests (FIFO).");
            return;
        }
        if (availableDrivers.isEmpty()) {
            System.out.println("No available drivers.");
            return;
        }

        RideRequest req = requestQueue.poll();
        Driver driver = availableDrivers.iterator().next();
        availableDrivers.remove(driver);

        Ride ride = new Ride(req, driver);
        System.out.println("Assigned (FIFO): " + ride);


        completeRide(ride);
    }


    public void assignNextHighPriority() {
        if (priorityQueue.isEmpty()) {
            System.out.println("No pending ride requests (priority).");
            return;
        }
        if (availableDrivers.isEmpty()) {
            System.out.println("No available drivers.");
            return;
        }

        RideRequest req = priorityQueue.poll();


        requestQueue.removeIf(r -> r.getRequestId().equals(req.getRequestId()));

        Driver driver = availableDrivers.iterator().next();
        availableDrivers.remove(driver);

        Ride ride = new Ride(req, driver);
        System.out.println("Assigned (HIGH PRIORITY): " + ride);


        completeRide(ride);
    }


    private void completeRide(Ride ride) {
        System.out.println("Ride completed: " + ride);
        rideHistory.add(ride);

        availableDrivers.add(ride.getDriver());
    }

    public void printRideHistory() {
        System.out.println("\n Ride History ");
        for (Ride ride : rideHistory) {
            System.out.println(ride);
        }
    }


    public static void main(String[] args) {
        RideSharingDispatchSystem system = new RideSharingDispatchSystem();


        system.addDriver(new Driver("D1", "Amit"));
        system.addDriver(new Driver("D2", "Priya"));
        system.addDriver(new Driver("D1", "Amit Duplicate"));


        system.addRideRequest(new RideRequest("R1", "A", "B", 3));
        system.addRideRequest(new RideRequest("R2", "C", "D", 9));
        system.addRideRequest(new RideRequest("R3", "E", "F", 5));


        system.assignNextRideFIFO();


        system.assignNextHighPriority();
        system.assignNextHighPriority();


        system.printRideHistory();
    }
}
