import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double total = 0.0;      // Hint a: total initialized to 0.0
        double input;            // Hint a: variable for user input
        
        // Hint b: while loop until input == 0
        while (true) {
            System.out.print("Enter number (0 to stop): ");
            input = sc.nextDouble();
            
            // Hint c: if not 0, add to total
            if (input != 0) {
                total += input;  // Add to total
                // Hint c: ask again (loop continues)
            } else {
                break;  // Exit when 0 entered
            }
        }
        
        // Hint d: display total outside loop
        System.out.println("Total sum: " + total);
        
        sc.close();
    }
}
