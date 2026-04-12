package com.gla.GenericsAndCollections.JavaCollection.QueueInterface;
import java.util.*;
public class HospitalTriage {
    public static class Patient {
        private String name;
        private int severity;

        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        public String getName() { return name; }
        public int getSeverity() { return severity; }

        @Override
        public String toString() {
            return String.format("Patient{name='%s', severity=%d}", name, severity);
        }
    }


    public static class PatientSeverityComparator implements Comparator<Patient> {
        @Override
        public int compare(Patient p1, Patient p2) {

            return Integer.compare(p2.getSeverity(), p1.getSeverity());
        }
    }


    public static class TriageSystem {
        private PriorityQueue<Patient> queue;

        public TriageSystem() {
            queue = new PriorityQueue<>(new PatientSeverityComparator());
        }


        public void addPatient(String name, int severity) {
            queue.add(new Patient(name, severity));
        }


        public Patient treatNext() {
            return queue.poll();
        }


        public boolean isEmpty() {
            return queue.isEmpty();
        }


        public List<Patient> getTreatmentOrder() {
            List<Patient> order = new ArrayList<>();
            PriorityQueue<Patient> temp = new PriorityQueue<>(new PatientSeverityComparator());
            temp.addAll(queue);

            while (!temp.isEmpty()) {
                order.add(temp.poll());
            }
            return order;
        }
    }


    public static void main(String[] args) {
        TriageSystem triage = new TriageSystem();


        triage.addPatient("John", 3);
        triage.addPatient("Alice", 5);
        triage.addPatient("Bob", 2);

        System.out.println("Hospital Triage (highest severity first):");
        while (!triage.isEmpty()) {
            Patient p = triage.treatNext();
            System.out.println(p);
        }


    }
}
