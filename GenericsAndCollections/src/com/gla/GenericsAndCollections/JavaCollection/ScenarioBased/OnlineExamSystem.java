package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Question {
    private int id;
    private String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() { return id; }
    public String getText() { return text; }

    @Override
    public String toString() {
        return "Q" + id + ": " + text;
    }
}

// Simple Student model
class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Student{" + studentId + ", " + name + "}";
    }
}
public class OnlineExamSystem {
    private List<Question> questions;
    private Set<String> studentIds;
    private Queue<Student> waitingQueue;
    private Stack<Question> navigationStack;

    public OnlineExamSystem() {
        this.questions        = new ArrayList<>();
        this.studentIds       = new HashSet<>();
        this.waitingQueue     = new LinkedList<>();
        this.navigationStack  = new Stack<>();
    }


    public boolean enrollStudent(Student student) {
        if (studentIds.add(student.getStudentId())) {
            waitingQueue.add(student);
            System.out.println("Enrolled: " + student);
            return true;
        } else {
            System.out.println("Duplicate ID, cannot enroll: " + student);
            return false;
        }
    }


    public void addQuestion(Question q) {
        questions.add(q);
    }


    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }


    public void serveStudents() {
        System.out.println("\n Serving students in queue order ");
        while (!waitingQueue.isEmpty()) {
            Student s = waitingQueue.poll();
            System.out.println("\nServing " + s);
            conductExamForStudent(s);
        }
    }


    private void conductExamForStudent(Student student) {

        navigationStack.clear();

        if (questions.isEmpty()) {
            System.out.println("No questions available for " + student.getName());
            return;
        }

        int index = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            Question current = questions.get(index);
            System.out.println("Current question: " + current);
            System.out.println("Options: [n]ext, [b]ack, [e]nd for this student");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("n")) {
                // Push current question to stack before moving forward
                navigationStack.push(current);
                if (index < questions.size() - 1) {
                    index++;
                } else {
                    System.out.println("This is the last question.");
                }
            } else if (choice.equals("b")) {
                //  Navigate back using stack
                if (!navigationStack.isEmpty()) {
                    Question previous = navigationStack.pop();
                    // find index of previous question in list
                    for (int i = 0; i < questions.size(); i++) {
                        if (questions.get(i).getId() == previous.getId()) {
                            index = i;
                            break;
                        }
                    }
                } else {
                    System.out.println("No previous question.");
                }
            } else if (choice.equals("e")) {
                System.out.println("Ending exam for " + student.getName());
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    // Demo main
    public static void main(String[] args) {
        OnlineExamSystem system = new OnlineExamSystem();


        system.enrollStudent(new Student("S001", "Rahul"));
        system.enrollStudent(new Student("S002", "Priya"));
        system.enrollStudent(new Student("S001", "DuplicateRahul"));


        system.addQuestion(new Question(1, "What is Java?"));
        system.addQuestion(new Question(2, "What is a JVM?"));
        system.addQuestion(new Question(3, "Explain OOP concepts."));
        system.addQuestion(new Question(4, "What is a Collection in Java?"));


        system.shuffleQuestions();


        system.serveStudents();
    }
}
