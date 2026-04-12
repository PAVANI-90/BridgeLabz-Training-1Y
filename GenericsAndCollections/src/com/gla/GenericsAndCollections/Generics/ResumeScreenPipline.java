package com.gla.GenericsAndCollections.Generics;
import java.util.*;

abstract class JobRole {
    abstract void evaluate();
}

// Job Role Implementations
class SoftwareEngineer extends JobRole {
    void evaluate() {
        System.out.println("Evaluating Software Engineer: Coding, DSA, System Design");
    }
}

class DataScientist extends JobRole {
    void evaluate() {
        System.out.println("Evaluating Data Scientist: ML, Statistics, Python");
    }
}

class ProductManager extends JobRole {
    void evaluate() {
        System.out.println("Evaluating Product Manager: Strategy, Communication, UX");
    }
}

// Generic Resume Class (Bounded Type)
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume of: " + candidateName);
        jobRole.evaluate();
    }

    public T getJobRole() {
        return jobRole;
    }
}

//  Screening System with Generic Method + Wildcard
class ScreeningSystem {

    // Generic Method
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening candidate...");
        resume.processResume();
    }

    // Wildcard Method
    public static void bulkScreen(List<? extends JobRole> roles) {
        System.out.println("\nBulk Screening Different Job Roles:");
        for (JobRole role : roles) {
            role.evaluate();
        }
    }
}


public class ResumeScreenPipline {
    public static void main(String[] args) {

        SoftwareEngineer se = new SoftwareEngineer();
        DataScientist ds = new DataScientist();
        ProductManager pm = new ProductManager();

        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", se);
        Resume<DataScientist> r2 = new Resume<>("Bob", ds);
        Resume<ProductManager> r3 = new Resume<>("Charlie", pm);

        ScreeningSystem.screenResume(r1);
        ScreeningSystem.screenResume(r2);
        ScreeningSystem.screenResume(r3);

        List<JobRole> roles = Arrays.asList(se, ds, pm);
        ScreeningSystem.bulkScreen(roles);
    }
}
