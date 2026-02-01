import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Hint a: Input for 3 friends
        System.out.println("Enter details for Amar:");
        System.out.print("Age: ");
        int amarAge = sc.nextInt();
        System.out.print("Height: ");
        double amarHeight = sc.nextDouble();
        
        System.out.println("\nEnter details for Akbar:");
        System.out.print("Age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Height: ");
        double akbarHeight = sc.nextDouble();
        
        System.out.println("\nEnter details for Anthony:");
        System.out.print("Age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Height: ");
        double anthonyHeight = sc.nextDouble();
        
        // Hint b: Find youngest (smallest age)
        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        System.out.println("\nYoungest age is: " + youngestAge);
        
        // Hint c: Find tallest (largest height)
        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        System.out.println("Tallest height is: " + tallestHeight);
        
        sc.close();
    }
}
