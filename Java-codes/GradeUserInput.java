import java.util.Scanner;

class GradeUserInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        if (marks >= 90) {
            System.out.println("Grade A");
        }
        else if (marks >= 70) {
            System.out.println("Grade B");
        }
        else if (marks >= 60) {
            System.out.println("Grade C");
        }
        else {
            System.out.println("Fail");
        }

        sc.close();
    }
}