class VariableExamples{ // class keyword with class name
int id = 10;      // ------Instance variable
String name= "Jay";   //---- Instance Variable

int rollNo;  //instance variable

static int age =20; // static variable.

void display()   // Method
{
   String status= "Active"; // local variable
System.out.println("Status: "+status);  // Printing statement
}
public static void main(String args[])  // main method
{

VariableExamples var= new VariableExamples();
var.display();  //non static method so we have to create object
var.rollNo= 20; // instance variable access using object

System.out.println(age); //  static variable access without any object


}
}