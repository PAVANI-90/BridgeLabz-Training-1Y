import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter base number: ");
        int number = sc.nextInt();
        
        System.out.print("Enter power: ");
        int power = sc.nextInt();
        
        if (number < 0 || power < 0) {
            System.out.println("Please enter positive integers!");
            sc.close();
            return;
        }
        
        
        long result = 1;
        
        
        for (int i = 1; i <= power; i++) {
            result *= number;  // Multiply result by number
        }
        
        
        System.out.println(number + " raised to " + power + " = " + result);
        
        sc.close();
    }
}
