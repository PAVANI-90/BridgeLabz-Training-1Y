import java.util.Scanner;

public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        // Hint a: Check natural number (positive integer)
        if (n < 1) {
            System.out.println("Please enter a positive integer!");
            sc.close();
            return;
        }
        
        // Hint a: For loop factorial
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        // Hint a: Print result
        System.out.println("Factorial of " + n + " is " + factorial);
        
        sc.close();
    }
}
