import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Hint a: Take integer input
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        
        // Hint b: For loop 6 to 9
        for (int i = 6; i <= 9; i++) {
            // Hint b: Print in format "number * i = result"
            System.out.println(number + " * " + i + " = " + (number * i));
        }
        
        sc.close();
    }
}
