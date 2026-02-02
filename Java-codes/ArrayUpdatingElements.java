import java.util.Scanner;
class ArrayUpdatingElements{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
int marks [] = {12 , 14 , 16, 18 ,20};
System.out.println("Updating elements: ");
marks[3]= 100;
System.out.println("Array elements: ");
for(int i = 0; i<marks.length; i++){
System.out.println(marks[i]);
}
}
}