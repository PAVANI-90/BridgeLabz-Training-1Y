import java.util.Scanner;

public class TriangleAreaCm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter base in cm: ");
        double baseCm = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();
        
        double areaSqCm = 0.5 * baseCm * heightCm;
        double areaSqIn = areaSqCm / (2.54 * 2.54);
        
        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f%n", 
                          areaSqIn, areaSqCm);
        
        sc.close();
    }
}
