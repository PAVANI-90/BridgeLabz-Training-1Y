import java.util.Scanner;
class Array_Input{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter array size : ");
int n= sc.nextInt();
int [] arr= new int[n];
for(int i=0;i<n;i++){
arr[i] = sc.nextInt();
}
}
}