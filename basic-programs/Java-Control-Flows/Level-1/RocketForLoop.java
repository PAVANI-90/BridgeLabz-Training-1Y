import java.util.Scanner;

public class RocketForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = sc.nextInt();
        
        // For loop countdown from counter to 1
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        sc.close();
    }
}
