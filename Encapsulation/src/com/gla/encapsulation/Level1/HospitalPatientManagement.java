package com.gla.encapsulation.Level1;
import java.util.*;

// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class with encapsulation
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    protected double billAmount;
    protected List<String> medicalHistory = new ArrayList<>();

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.billAmount = 0;
    }

    // Encapsulation: getters/setters (no direct medicalHistory setter)
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getBillAmount() { return billAmount; }
    public List<String> getMedicalHistory() { return new ArrayList<>(medicalHistory); }

    // Abstract billing method
    public abstract double calculateBill();

    // Concrete details method
    public void getPatientDetails() {
        billAmount = calculateBill();
        System.out.printf("Patient ID: %d, %s (Age: %d) | Bill: $%.2f%n",
                patientId, name, age, billAmount);
    }
}

// InPatient subclass (with medical records)
class InPatient extends Patient implements MedicalRecord {
    private double roomChargePerDay;
    private int daysAdmitted;

    public InPatient(int patientId, String name, int age, double roomChargePerDay, int daysAdmitted) {
        super(patientId, name, age);
        this.roomChargePerDay = roomChargePerDay;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return (roomChargePerDay * daysAdmitted) + 1500 + (daysAdmitted * 200);
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add("InPatient: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : medicalHistory) {
            System.out.println("  - " + record);
        }
    }
}

// OutPatient subclass (with medical records)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private int numVisits;

    public OutPatient(int patientId, String name, int age, double consultationFee, int numVisits) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.numVisits = numVisits;
    }

    @Override
    public double calculateBill() {
        return (consultationFee * numVisits) + 300 * numVisits;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add("OutPatient: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : medicalHistory) {
            System.out.println("  - " + record);
        }
    }
}

// Main class - polymorphism demo
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // List of Patient references
        List<Patient> patients = new ArrayList<>();

        InPatient inPt1 = new InPatient(1001, "Alice Johnson", 45, 500.0, 3);
        OutPatient outPt1 = new OutPatient(2001, "Bob Smith", 32, 150.0, 4);
        InPatient inPt2 = new InPatient(1002, "Carol White", 60, 600.0, 5);
        OutPatient outPt2 = new OutPatient(2003, "David Lee", 28, 120.0, 2);

        patients.add(inPt1);
        patients.add(outPt1);
        patients.add(inPt2);
        patients.add(outPt2);

        // Add sample records
        if (inPt1 instanceof MedicalRecord) {
            ((MedicalRecord) inPt1).addRecord("Appendectomy surgery");
            ((MedicalRecord) inPt1).addRecord("Post-op recovery");
        }
        if (outPt1 instanceof MedicalRecord) {
            ((MedicalRecord) outPt1).addRecord("Flu consultation");
            ((MedicalRecord) outPt1).addRecord("Prescription issued");
        }

        System.out.println("Hospital Patient Management System\n");

        // Polymorphic billing processing
        System.out.println("Billing Details");
        for (Patient pt : patients) {
            pt.getPatientDetails();
        }

        System.out.println("\nMedical Records (Sample)");
        inPt1.viewRecords();
        outPt1.viewRecords();
    }
}

