import java.util.Scanner;

public class NaturalSumForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        // Hint a: Check if natural number (n >= 1)
        if (n >= 1) {
            // Hint b: Formula: n*(n+1)/2
            int formulaSum = n * (n + 1) / 2;
            
            // Hint b: For loop method
            int forSum = 0;
            for (int i = 1; i <= n; i++) {
                forSum += i;
            }
            
            // Hint c: Compare results
            System.out.println("Formula result: " + formulaSum);
            System.out.println("For loop result: " + forSum);
            
            if (formulaSum == forSum) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("Results don't match!");
            }
        } else {
            System.out.println(n + " is not a natural number");
        }
        
        sc.close();
    }
}
