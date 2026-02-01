import java.util.Scanner;

public class LargestCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number1: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter number2: ");
        int num2 = sc.nextInt();
        
        System.out.print("Enter number3: ");
        int num3 = sc.nextInt();
        
        if (num1 > num2 && num1 > num3) {
            System.out.println("Is the first number the largest? Yes");
        
		} 
        else if (num2 > num1 && num2 > num3) {
            System.out.println("Is the second number the largest? Yes");
            
        } 
        else {
            System.out.println("Is the third number the largest? Yes");
 
        } 
        
        sc.close();
    }
}
