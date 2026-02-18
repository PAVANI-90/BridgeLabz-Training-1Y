package com.gla.methods.Level1;
import java.util.Scanner;

public class MaxNumberHandshake {
    public static long calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1L)) / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        long maxHandshakes = calculateHandshakes(numberOfStudents);

        System.out.printf("Maximum number of handshakes possible among %d students: %d\n",
                numberOfStudents, maxHandshakes);

        sc.close();
    }
}

