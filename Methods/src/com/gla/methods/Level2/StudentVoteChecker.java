package com.gla.methods.Level2;
import java.util.Scanner;
public class StudentVoteChecker {
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentAges = new int[10];
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            studentAges[i] = sc.nextInt();
        }
        System.out.println("\nVoting Eligibility:");
        int canVoteCount = 0;
        for (int i = 0; i < 10; i++) {
            boolean eligible = canStudentVote(studentAges[i]);
            String status = eligible ? "CAN VOTE ✓" : "Cannot vote ✗";
            System.out.printf("Student %d (age %d): %s\n",
                    i + 1, studentAges[i], status);
            if (eligible) {
                canVoteCount++;
            }
        }
        System.out.printf("\nTotal students who can vote: %d/10\n", canVoteCount);
        sc.close();
    }
}

