import java.util.Scanner;
public class AverageOfThreeNumber{
      static Scanner sc = new Scanner(System.in);
    public static void perimeter(){
        System.out.println("Enter the first no.:");
        double a = sc.nextDouble();
        System.out.println("Enter the second no.:");
        double b = sc.nextDouble();
        System.out.println("Enter the third no.:");
        double c = sc.nextDouble();
        double f = (a+b+c)/3;  
        System.out.println("The value is:" + f);
    }
    public static void main(String[] args){
        perimeter();
    }
}