import java.util.Scanner;

public class SumUntilZeroNeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double total = 0.0;
        double input;
        
        // Hint a: Infinite while loop
        while (true) {
            System.out.print("Enter number (0 or negative to stop): ");
            input = sc.nextDouble();
            
            // Hint b: Break if 0 or negative
            if (input <= 0) {
                break;
            }
            
            // Add positive numbers only
            total += input;
        }
        
        System.out.println("Total sum: " + total);
        sc.close();
    }
}
