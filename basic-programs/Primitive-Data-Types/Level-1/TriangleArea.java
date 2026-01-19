import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter base in inches: ");
        double baseInches = sc.nextDouble();
        System.out.print("Enter height in inches: ");
        double heightInches = sc.nextDouble();
        
        // Area calculations
        double areaSqInches = 0.5 * baseInches * heightInches;
        double areaSqCm = areaSqInches * 6.4516;  // 1 sq in = 6.4516 sq cm
        
        // Height conversions
        double heightCm = heightInches * 2.54;
        double heightFeet = heightCm * 0.0328084;  // or heightInches / 12.0
        double heightInchesFormatted = heightInches;
        
        // Outputs
        System.out.printf("Area in square inches: %.2f%n", areaSqInches);
        System.out.printf("Area in square centimeters: %.2f%n", areaSqCm);
        System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f%n", 
                          heightCm, heightFeet, heightInchesFormatted);
        
        sc.close();
    }
}
