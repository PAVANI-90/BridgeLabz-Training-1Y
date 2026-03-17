class Animal{  // parent class 
void eat();
System.out.println("Animal is eating");
}
class Dog extends Animal{    // Child class
 void bark(){      // child class method
 System.ouut.println("Dog is barking");
 }
 }
 public class SingleInheritanceExample {
 public static void main(String[] args){
 Dog d = new Dog();
 d.eat(); // inherited method
 d.bark(); // own method
}
}