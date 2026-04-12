package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Student {
    private String id;
    private String name;
    private double marks; // entrance / exam marks

    public Student(String id, String name, double marks) {
        this.id    = id;
        this.name  = name;
        this.marks = marks;
    }

    public String getId()    { return id; }
    public String getName()  { return name; }
    public double getMarks() { return marks; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id.equals(s.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" + id + ", " + name + ", marks=" + marks + "}";
    }
}
public class CollegeAdmissionSystem {
    private List<Student> allApplicants;


    private Set<Student> shortlisted;


    private Queue<Student> interviewQueue;


    private TreeSet<Student> meritList;


    private double cutoffMarks = 75.0;
    public CollegeAdmissionSystem() {
        this.allApplicants  = new ArrayList<>();
        this.shortlisted    = new HashSet<>();
        this.interviewQueue = new LinkedList<>();
        this.meritList      = new TreeSet<>(
                (s1, s2) -> {
                    int cmp = Double.compare(s2.getMarks(), s1.getMarks());
                    if (cmp != 0) return cmp;
                    return s1.getId().compareTo(s2.getId());
                }
        );
    }
    public void addApplicant(Student s) {
        allApplicants.add(s);
        System.out.println("Application received: " + s);
    }
    public void shortlistEligibleStudents() {
        System.out.println("\n Shortlisting students (marks >= " + cutoffMarks + ") ");
        for (Student s : allApplicants) {
            if (s.getMarks() >= cutoffMarks) {
                if (shortlisted.add(s)) {
                    System.out.println("Shortlisted: " + s);
                }
            }
        }
    }
    public void createInterviewQueue() {
        System.out.println("\n Creating interview queue from shortlisted students ");
        for (Student s : shortlisted) {
            interviewQueue.add(s);
            System.out.println("Enqueued for interview: " + s);
        }
    }
    public void conductInterviewsAndBuildMeritList() {
        System.out.println("\n Conducting interviews ");
        Random rand = new Random();

        while (!interviewQueue.isEmpty()) {
            Student s = interviewQueue.poll();
            System.out.println("\nInterviewing: " + s);
            boolean selected = rand.nextDouble() < 0.7;
            if (selected) {
                meritList.add(s);
                System.out.println("   Selected, added to merit list.");
            } else {
                System.out.println("   Not selected.");
            }
        }
    }
    public void printMeritList() {
        System.out.println("\n Final Merit List (sorted by marks desc) ");
        int rank = 1;
        for (Student s : meritList) {
            System.out.println(rank + ". " + s.getName() +
                    " (ID=" + s.getId() +
                    ", Marks=" + s.getMarks() + ")");
            rank++;
        }
    }

    public void printApplicants() {
        System.out.println("\n All Applicants ");
        for (Student s : allApplicants) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        CollegeAdmissionSystem system = new CollegeAdmissionSystem();
        system.addApplicant(new Student("S001", "Amit", 82.5));
        system.addApplicant(new Student("S002", "Priya", 91.0));
        system.addApplicant(new Student("S003", "Rahul", 68.0));
        system.addApplicant(new Student("S004", "Sneha", 77.0));
        system.addApplicant(new Student("S005", "Vikas", 72.0));
        system.addApplicant(new Student("S006", "Anita", 88.5));

        system.printApplicants();
        system.shortlistEligibleStudents();
        system.createInterviewQueue();
        system.conductInterviewsAndBuildMeritList();
        system.printMeritList();
    }
}
