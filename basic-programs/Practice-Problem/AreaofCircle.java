import java.util.Scanner;
public class AreaOfACircle {
    public static void area(Scanner sc){
            System.out.println("Enter the rdius :");
            double a= sc.nextDouble();
            double f = 3.14*a*a;
            System.out.println("Area of circle ="+ f);
    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            area(sc);
    }
}