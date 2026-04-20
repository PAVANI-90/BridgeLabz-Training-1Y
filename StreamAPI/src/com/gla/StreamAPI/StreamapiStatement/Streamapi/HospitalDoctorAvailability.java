package com.gla.StreamAPI.StreamapiStatement.Streamapi;
import java.util.*;
import java.util.stream.Collectors;

class Doctor {
    String name;
    String specialty;
    boolean satAvailable;
    boolean sunAvailable;

    Doctor(String name, String specialty, boolean satAvailable, boolean sunAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.satAvailable = satAvailable;
        this.sunAvailable = sunAvailable;
    }

    boolean isWeekendAvailable() {
        return satAvailable || sunAvailable;
    }

    String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return name + " (" + specialty + ") - Sat: " + satAvailable + ", Sun: " + sunAvailable;
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Smith", "Cardiology", true, false),
                new Doctor("Dr. Johnson", "Neurology", true, true),
                new Doctor("Dr. Williams", "Cardiology", false, true),
                new Doctor("Dr. Brown", "Orthopedics", true, true),
                new Doctor("Dr. Jones", "Neurology", false, false),
                new Doctor("Dr. Garcia", "Orthopedics", true, false)
        );

        List<Doctor> weekendDoctors = doctors.stream()
                .filter(Doctor::isWeekendAvailable)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .collect(Collectors.toList());

        System.out.println("Doctors available on weekends (sorted by specialty):");
        weekendDoctors.forEach(System.out::println);
    }
}
