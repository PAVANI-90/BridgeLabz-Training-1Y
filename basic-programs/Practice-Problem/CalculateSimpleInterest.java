import java.util.Scanner;
public class CalculateSimpleInterest{
    public static void calculate(Scanner sc){
        System.out.println("Enter the principal amount:");
        int p = sc.nextInt();
        System.out.println("Enter the rate:");
        double r = sc.nextDouble();
        System.out.println("Enter the time in year:");
        int t = sc.nextInt();
        double si = (p*r*t)/100;
        System.out.println("The simple interest is " + String.format("%.2f",si));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        calculate(sc);
    }
}