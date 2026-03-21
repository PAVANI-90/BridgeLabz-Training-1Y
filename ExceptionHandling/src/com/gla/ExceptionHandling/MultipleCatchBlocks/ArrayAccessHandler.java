package com.gla.ExceptionHandling.MultipleCatchBlocks;

import java.util.Scanner;

public class ArrayAccessHandler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        int[] arr = null;

        if (size > 0) {
            arr = new int[size];
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.print("Enter index: ");
        int index = sc.nextInt();
        sc.close();

        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Invalid index");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Array is null");
        }
    }
}
