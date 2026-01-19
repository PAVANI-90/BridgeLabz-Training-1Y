import java.util.Scanner;
public class KilometerstoMiles{
    static Scanner sc = new Scanner(System.in);
    public static void miles(){
        System.out.println("Enter the distance in kilometer :");
        double k= sc.nextDouble();
        double miles = k*0.621371;
        System.out.println("Distance in miles ="+ miles);
    }
    public static void main(String[] args) {
        miles();
    }
}