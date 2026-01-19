import java.util.Scanner;

public class AddTwoNumbers{
    public static void add(Scanner sc){
        System.out.println("Enter First no.");
        int a= sc.nextInt();
        System.out.println("Enter Second no.");
        int b= sc.nextInt();
        int s = a+b;
        System.out.println("Sum =" + s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        add(sc);
    }
}
