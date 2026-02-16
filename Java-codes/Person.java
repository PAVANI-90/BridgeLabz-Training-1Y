import java.util.Scanner;
// Parent Class
class Person {

int x = 10; // parent variable

// Parent constructor
Person() {
System.out.println("Person Constructor Called");
}

// Parent method
void show() {
System.out.println("Person Method Called");
}
}
// Child Class
class Employee extends Person {

int x = 20; // child variable

Employee() {

// Calling parent constructor
super();

// Access parent variable
System.out.println("Parent variable x = " + super.x);

// Calling parent method
super.show();

System.out.println("Employee Constructor Called");
}

public static void main(String[] args) {
Employee e = new Employee();
}
}