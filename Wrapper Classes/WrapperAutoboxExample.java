public class WrapperAutoboxExample{
public static void main(String[] args){
int a = 10; // primitive
// Integer val1 = Integer.valueof(a); // internally conversion through compiler
Integer value = a;  // autoboxing ( converting primitive to objects )
System.out.println("Value: "+value);
}
}