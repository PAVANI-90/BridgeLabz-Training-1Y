import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Hint b: Take salary and years of service
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        
        System.out.print("Enter years of service: ");
        int years = sc.nextInt();
        
        double bonus = 0.0;
        
        // Hint a: 5% bonus if years > 5
        if (years > 5) {
            bonus = salary * 0.05;  // 5% of salary
        }
        
        // Hint c: Print bonus
        System.out.println("Bonus: " + bonus);
        
        sc.close();
    }
}
