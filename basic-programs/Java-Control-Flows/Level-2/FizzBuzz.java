import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Hint a: Take input and check positive integer
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if (number < 1) {
            System.out.println("Please enter a positive integer!");
            sc.close();
            return;
        }
        
        // Hint a: For loop 1 to number
        for (int i = 1; i <= number; i++) {
            // Check multiples (in order!)
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } 
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            } 
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            } 
            else {
                System.out.println(i);
            }
        }
        
        sc.close();
    }
}
