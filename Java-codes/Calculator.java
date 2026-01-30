import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        double add = num1 + num2;
        double sub = num1 - num2;
        double mul = num1 * num2;
        
        System.out.printf("Addition: %.2f%n", add);
        System.out.printf("Subtraction: %.2f%n", sub);
        System.out.printf("Multiplication: %.2f%n", mul);
        
        if (num2 != 0) {
            double div = num1 / num2;
            System.out.printf("Division: %.2f%n", div);
        } else {
            System.out.println("Division: Error - Division by zero!");
        }
        
        sc.close();
    }
}
