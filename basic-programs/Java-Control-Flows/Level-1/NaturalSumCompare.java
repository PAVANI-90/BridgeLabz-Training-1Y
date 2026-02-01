import java.util.Scanner;

public class NaturalSumCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        // Hint a: Check if natural number (n >= 1)
        if (n >= 1) {
            // Hint b: Formula method: n*(n+1)/2
            int formulaSum = n * (n + 1) / 2;
            
            // Hint b: While loop method
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }
            
            // Hint c: Compare and print results
            System.out.println("Formula result: " + formulaSum);
            System.out.println("While loop result: " + loopSum);
            
            if (formulaSum == loopSum) {
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
