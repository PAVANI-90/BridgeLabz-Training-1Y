import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter a positive integer (<100): ");
        int number = sc.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100!");
            sc.close();
            return;
        }
        
        System.out.print("Multiples of " + number + " below 100: ");
        
        
        int counter = 99;  // Start from largest multiple below 100
        while (counter >= number) {  // While counter >= number (covers all multiples)
            
            if (counter % number == 0) {
                System.out.print(counter + " ");
            }
            counter--;  // Decrement
        }
        System.out.println();
        
        sc.close();
    }
}
