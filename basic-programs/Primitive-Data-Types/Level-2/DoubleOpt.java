import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        
        double op1 = a + b * c;      // * before +
        double op2 = a * b + c;      // * before +
        double op3 = c + a / b;      // / before +
        double op4 = a % b + c;      // % before +
        
        System.out.printf("The results of Double Operations are %.2f, %.2f, %.2f, and %.2f%n", 
                          op1, op2, op3, op4);
        
        sc.close();
    }
}
