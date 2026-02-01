import java.util.Scanner;
public class SmallestCheck{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Enter number1:");
int num1 = sc.nextInt();
System.out.print("Enter number2:");
int num2 = sc.nextInt();
System.out.print("Enter number3:");
int num3 = sc.nextInt();
if (num1<num2 && num1<num3){
System.out.println("Is the first number the smallest? YES");
}
else{
System.out.println("Is the first number the smallest? NO");
}
sc.close();
}
}
