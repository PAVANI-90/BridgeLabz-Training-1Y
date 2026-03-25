package com.gla.Threads;
class Device implements Runnable {
    private String deviceName;
    private long sleepInterval;
    private int priority;

    public Device(String deviceName, long sleepInterval, int priority) {
        this.deviceName = deviceName;
        this.sleepInterval = sleepInterval;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int cycle = 1; cycle <= 5; cycle++) {
            long timestamp = System.currentTimeMillis();
            System.out.printf("[%d] %s (Priority: %d) - Cycle %d Status: Active%n",
                    timestamp, deviceName, priority, cycle);
            try {
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
public class SmartHomeAutomation {
    public static void main(String[] args) {

        Device tempSensor = new Device("Temperature Sensor", 5000, 7);
        Device securityCam = new Device("Security Camera", 3000, Thread.MAX_PRIORITY);  // 10
        Device lightCtrl = new Device("Light Controller", 4000, 5);
        Device doorLock = new Device("Door Lock Monitor", 6000, 5);


        Thread t1 = new Thread(tempSensor, "TempThread");
        Thread t2 = new Thread(securityCam, "CamThread");
        Thread t3 = new Thread(lightCtrl, "LightThread");
        Thread t4 = new Thread(doorLock, "DoorThread");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println("All devices completed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
