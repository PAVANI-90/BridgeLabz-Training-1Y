package com.gla.ClassQuiz;

public class RotationOfElement {
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, 0, n - 1);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrLeft = {10, 20, 30, 40, 50, 60, 70}; // array which lefting
        int k = 3;      // already given in question that input : int k =3;
        System.out.print("Original: ");
        printArray(arrLeft);

        rotateLeft(arrLeft, k);
        System.out.print("Left by " + k + ": ");
        printArray(arrLeft);

        int[] arrRight = {10, 20, 30, 40, 50, 60, 70};
        rotateRight(arrRight, k);
        System.out.print("Right by " + k + ": ");
        printArray(arrRight);
    }
}

