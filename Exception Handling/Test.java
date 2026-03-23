public class Test {
void checkAge(int age){
try {
if (age<18){
throw new Exception("Not eligible to vote");
System.out.println("Eligible to vote");
}
catch (Exception e){
System.out.println("Handled: "+e.getMessage());
}
}
public static void main (String[] args){
test t = new test();
t.checkAge(17);
}
}