import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        int greatestFactor = 1;
        
        if (number < 1) {
            System.out.println("Please enter a positive integer!");
            sc.close();
            return;
        }
        
        
        int counter = number - 1;
        
        
        while (counter >= 1) {
            
            if (number % counter == 0) {
                greatestFactor = counter;  // Assign largest factor
                break;  // Hint e: Break immediately
            }
            counter--;  // Decrement
        }
        
        
        System.out.println("Greatest factor (besides itself): " + greatestFactor);
        
        sc.close();
    }
}
