import java.util.Scanner;

public class RocketCountdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = sc.nextInt();
        
        // Hint b: while loop checks if counter >= 1
        while (counter >= 1) {
            // Hint c: print counter
            System.out.println(counter);
            // Hint c: decrement counter
            counter--;
        }
        
        sc.close();
    }
}
