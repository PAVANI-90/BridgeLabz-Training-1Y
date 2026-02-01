import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Hint a: Get input and check positive integer
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if (number < 1) {
            System.out.println("Please enter a positive integer!");
            sc.close();
            return;
        }
        
        // Hint b: For loop 1 to number-1
        System.out.print("Factors of " + number + ": ");
        for (int i = 1; i < number; i++) {
            // Hint b: Check perfect divisibility
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        sc.close();
    }
}
