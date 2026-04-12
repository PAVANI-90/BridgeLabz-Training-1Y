package com.gla.GenericsAndCollections.Generics;
import java.util.*;

abstract class CourseType {
    protected String name;

    public CourseType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super("Exam-Based: " + name);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super("Assignment-Based: " + name);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super("Research-Based: " + name);
    }
}


class Course<T extends CourseType> {
    private String courseCode;
    private String title;
    private T evaluationType;
    private List<String> students = new ArrayList<>();

    public Course(String courseCode, String title, T evaluationType) {
        this.courseCode = courseCode;
        this.title = title;
        this.evaluationType = evaluationType;
    }

    public void enrollStudent(String student) {
        students.add(student);
    }

    public void displayCourseInfo() {
        System.out.println("Course " + courseCode + " (" + title + ")");
        System.out.println("  Type: " + evaluationType);
        System.out.println("  Enrolled: " + students);
    }

    public T getEvaluationType() {
        return evaluationType;
    }
}

class UniversityManager {

    public static void displayAllCourses(List<CourseType> courseTypes) {
        System.out.println("All courses in university:");
        for (CourseType ct : courseTypes) {
            System.out.println("  " + ct);
        }
    }
}
public class UniversityCourseDemo {
    public static void main(String[] args) {

        Course<ExamCourse> examCourse = new Course<>("CS101", "Data Structures", new ExamCourse("Midterm + Final"));
        examCourse.enrollStudent("Alice");
        examCourse.enrollStudent("Bob");

        Course<AssignmentCourse> assignmentCourse = new Course<>("CS201", "Web Development", new AssignmentCourse("Projects"));
        assignmentCourse.enrollStudent("Charlie");

        Course<ResearchCourse> researchCourse = new Course<>("CS301", "Machine Learning", new ResearchCourse("Thesis"));
        researchCourse.enrollStudent("David");


        examCourse.displayCourseInfo();
        System.out.println();
        assignmentCourse.displayCourseInfo();
        System.out.println();
        researchCourse.displayCourseInfo();
        System.out.println();


        List<CourseType> allCourseTypes = new ArrayList<>();
        allCourseTypes.add(examCourse.getEvaluationType());
        allCourseTypes.add(assignmentCourse.getEvaluationType());
        allCourseTypes.add(researchCourse.getEvaluationType());

        UniversityManager.displayAllCourses(allCourseTypes);
    }
}
