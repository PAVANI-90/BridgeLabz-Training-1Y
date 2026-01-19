import java.util.Scanner;
public class PerimeterOfARectangle{
    static Scanner sc = new Scanner(System.in);
    public static void perimeter(){
        System.out.println("Enter the Length:");
        double l = sc.nextDouble();
        System.out.println("Enter the width:");
        double w = sc.nextDouble();
        double p = 2*(l+w);
        System.out.println("The perimeter of rectangle is:" + String.format("%.2f",p));
    }
    public static void main(String[] args){
        perimeter();
    }
}