package com.gla.methods.Level3;
import java.util.Random;
import java.util.Scanner;
public class MatrixOperationTransposeDeterInverse {
    static int[][] createMatrix(int r, int c) {
        Random rand = new Random();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = rand.nextInt(10); // 0–9
            }
        }
        return matrix;
    }
    static int[][] add(int[][] A, int[][] B) {
        int r = A.length;
        int c = A[0].length;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }
    static int[][] subtract(int[][] A, int[][] B) {
        int r = A.length;
        int c = A[0].length;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] - B[i][j];

        return result;
    }
    static int[][] multiply(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;
        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int r = sc.nextInt();
        System.out.print("Enter columns: ");
        int c = sc.nextInt();
        int[][] A = createMatrix(r, c);
        int[][] B = createMatrix(r, c);
        System.out.println("\nMatrix A:");
        display(A);
        System.out.println("\nMatrix B:");
        display(B);
        System.out.println("\nAddition:");
        display(add(A, B));
        System.out.println("\nSubtraction:");
        display(subtract(A, B));
        System.out.println("\nMultiplication:");
        display(multiply(A, B));
        sc.close();
    }
}
