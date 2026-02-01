import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        // Hint b: Check positive integer
        if (n < 1) {
            System.out.println("Please enter a positive integer!");
            sc.close();
            return;
        }
        
        // Hint c: While loop for factorial
        long factorial = 1;  // Use long for large results
        int i = 1;
        while (i <= n) {
            factorial *= i;  // Multiply: 1 * 1 * 2 * 3 * ...
            i++;
        }
        
        // Hint d: Print result
        System.out.println("Factorial of " + n + " is " + factorial);
        
        sc.close();
    }
}
