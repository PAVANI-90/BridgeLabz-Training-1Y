public class WrapperUnboxingExample{
public static void main(String[] args){
int a = 10;
Integer value = a; 
int unbox = value ; 
int i3 = value.intvalue(); // internally compiler converting objects to primitive 
System.out.println(i3);
System.out.println("Unboxing "+unbox );
}
}