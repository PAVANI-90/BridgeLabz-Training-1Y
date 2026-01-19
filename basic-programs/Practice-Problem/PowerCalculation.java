import java.util.Scanner;
public class PowerCalculation{
    static Scanner sc = new Scanner(System.in);
    public static void perimeter(){
        System.out.println("Enter the base:");
        double b = sc.nextDouble();
        System.out.println("Enter the exponemt:");
        int e = sc.nextInt();
        double v = Math.pow(b, e); 
        System.out.println("The value is:" + v);
    }
    public static void main(String[] args){
        perimeter();
    }
}