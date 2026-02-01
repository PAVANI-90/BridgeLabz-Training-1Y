import java.util.Scanner;

public class FactorsWhile {
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
        
        // Hint b: Counter variable for while loop
        int counter = 1;
        System.out.print("Factors of " + number + ": ");
        
        // Hint b: While loop till counter < number
        while (counter < number) {
            // Hint b: Check divisibility
            if (number % counter == 0) {
                System.out.print(counter + " ");
            }
            counter++;  // Increment counter
        }
        System.out.println();
        
        sc.close();
    }
}
