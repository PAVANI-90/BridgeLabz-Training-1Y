package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Patient {
    private String id;
    private String name;
    private String condition;
    private String status;
    public Patient(String id, String name, String condition) {
        this.id        = id;
        this.name      = name;
        this.condition = condition;
        this.status    = "ADMITTED";
    }

    public String getId()        { return id; }
    public String getName()      { return name; }
    public String getCondition() { return condition; }
    public String getStatus()    { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient p = (Patient) o;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Patient{" + id + ", " + name +
                ", condition=" + condition +
                ", status=" + status + "}";
    }
}
public class HospitalPatientManagementSystem {
    private Set<Patient> admittedPatients;
    private Queue<Patient> treatmentQueue;
    private Stack<Patient> dischargedStack;
    private List<Patient> patientHistory;

    public HospitalPatientManagementSystem() {
        this.admittedPatients = new HashSet<>();
        this.treatmentQueue = new LinkedList<>();
        this.dischargedStack = new Stack<>();
        this.patientHistory = new ArrayList<>();
    }

    public boolean admitPatient(Patient p) {
        if (admittedPatients.add(p)) {
            treatmentQueue.add(p);
            patientHistory.add(p);
            System.out.println("Admitted and queued: " + p);
            return true;
        } else {
            System.out.println("Duplicate admission ignored for patient ID: " + p.getId());
            return false;
        }
    }

    public void treatNextPatient() {
        if (treatmentQueue.isEmpty()) {
            System.out.println("\nNo patients waiting for treatment.");
            return;
        }
        Patient p = treatmentQueue.poll();
        p.setStatus("IN_TREATMENT");
        System.out.println("\nTreating patient: " + p);
        dischargePatient(p);
    }

    private void dischargePatient(Patient p) {
        p.setStatus("DISCHARGED");
        admittedPatients.remove(p);
        dischargedStack.push(p);
        System.out.println("Discharged patient: " + p);
    }

    public void readmitLastDischarged() {
        if (dischargedStack.isEmpty()) {
            System.out.println("\nNo recently discharged patient to re-admit.");
            return;
        }

        Patient p = dischargedStack.pop();
        System.out.println("\nRe-admitting recently discharged patient: " + p.getId());

        p.setStatus("ADMITTED");
        if (admittedPatients.add(p)) {
            treatmentQueue.add(p);
            System.out.println("Re-admitted and queued: " + p);
        } else {
            System.out.println("Patient already admitted, skipping re-admission.");
        }
    }

    public void printSummary() {
        System.out.println("\nHospital Summary ");
        System.out.println("Currently admitted patients: " + admittedPatients.size());
        System.out.println("Waiting for treatment: " + treatmentQueue.size());
        System.out.println("Recently discharged (stack size): " + dischargedStack.size());
        System.out.println("Total patient history entries: " + patientHistory.size());

        System.out.println("\nAdmitted patients:");
        for (Patient p : admittedPatients) {
            System.out.println(" " + p);
        }

        System.out.println("\nWaiting queue:");
        for (Patient p : treatmentQueue) {
            System.out.println(" " + p);
        }

        System.out.println("\nRecently discharged (top is most recent):");
        for (Patient p : dischargedStack) {
            System.out.println(" " + p);
        }
    }

    public static void main(String[] args) {
        HospitalPatientManagementSystem system = new HospitalPatientManagementSystem();

        system.admitPatient(new Patient("P001", "Rahul", "Flu"));
        system.admitPatient(new Patient("P002", "Priya", "Fever"));
        system.admitPatient(new Patient("P003", "Amit", "Injury"));
        system.admitPatient(new Patient("P001", "Rahul Duplicate", "Flu"));

        system.printSummary();

        system.treatNextPatient();
        system.treatNextPatient();

        system.printSummary();

        system.readmitLastDischarged();

        system.printSummary();
    }
}
