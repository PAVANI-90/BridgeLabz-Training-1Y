import java.util.Scanner;

public class CelsiusToFahrenheitConversion{
     public static void convert(Scanner sc){
        System.out.println("Enter temp. in celcius:");
        double a= sc.nextInt();
        double f = (a * 9/5) + 32;
        System.out.println("Fahrenheit ="+ f);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        convert(sc);
    }
       
    
}