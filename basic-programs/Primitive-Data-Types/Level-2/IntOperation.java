import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter c: ");
        int c = sc.nextInt();
        
        int op1 = a + b * c;      // * before +
        int op2 = a * b + c;      // * before +
        int op3 = c + a / b;      // / before +
        int op4 = a % b + c;      // % before +
        
        System.out.printf("The results of Int Operations are %d, %d, %d, and %d%n", 
                          op1, op2, op3, op4);
        
        sc.close();
    }
}
