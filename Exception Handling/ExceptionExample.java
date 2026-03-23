
public class ExceptionExample;
public static void main(String[]args){
int a=10;
int b=0;
try{
int n=a/b;
system.out.println("number: "+n);
}
catch(ArithmeticException e){
system.out.println("Divisible by 0");
}
finally{
System.out.println("This program run properly.");
}
}
