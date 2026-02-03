import java.util.*;

class SumOfTwoDArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows");
        int r = sc.nextInt();

        System.out.println("Enter columns");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        // Taking input
        System.out.println("Enter elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();  
            }
        }

        // Calculating sum
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += arr[i][j];        
            }
        }

        System.out.println("Sum of 2D array: " + sum);
    }
}