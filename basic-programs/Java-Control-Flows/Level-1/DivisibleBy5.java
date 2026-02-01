import java.util.Scanner;
public class DivisibleBy5{
public static void main(String[] args){
Scanner sc = new Scanner(System.IN);
System.out.print("Enter any number:");
int number = sc.nextInt();
if (number%5==0){
System.out.println("Is the number divisible by 5:YES ");
}
else {
System.out.println("Is the number divisible by 5:NO");
}
sc.close();
}
}