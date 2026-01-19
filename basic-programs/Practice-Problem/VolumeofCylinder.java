import java.util.Scanner;
public class VolumeOfACylinder{
     public static void volume(Scanner sc){
        System.out.println("Enter Radius:");
        double r= sc.nextDouble();
        System.out.println("Enter Height:");
        double h= sc.nextDouble();
        double v = Math.PI*r*r*h;
        System.out.println("Volume =" + v);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        volume(sc);
    }
}