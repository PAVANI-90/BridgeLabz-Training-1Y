import java.util.Scanner;

public class NaturalCheckSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        
        if (n >= 1) {
            // Formula: sum = n * (n + 1) / 2
            int sum = n * (n + 1) / 2;
            System.out.println("The sum of n natural numbers is " + sum);
        } else {
            System.out.println("The number n is not a natural number");
        }
        
        sc.close();
    }
}
