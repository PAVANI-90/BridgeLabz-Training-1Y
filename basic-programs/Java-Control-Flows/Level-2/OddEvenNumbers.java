import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Hint a: Check natural number
        if (number < 1) {
            System.out.println("Please enter a natural number!");
            sc.close();
            return;
        }
        
        // Hint b: For loop from 1 to number
        for (int i = 1; i <= number; i++) {
            // Hint c: Check odd/even using % 2
            if (i % 2 == 0) {
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }
        
        sc.close();
    }
}
