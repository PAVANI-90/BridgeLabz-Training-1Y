class Animal {      // Grandparent (Level 1)
    String name;
    
    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {  // Parent (Level 2)
    void bark() {
        System.out.println(name + " is barking");
    }
}

class Puppy extends Dog {   // Child (Level 3)
    void play() {
        System.out.println(name + " puppy is playing");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Puppy myPuppy = new Puppy();
        
        myPuppy.name = "Tommy";
        
        myPuppy.eat();   // From Animal → "Tommy is eating"
        myPuppy.bark();  // From Dog → "Tommy is barking"  
        myPuppy.play();  // From Puppy → "Tommy puppy is playing"
    }
}