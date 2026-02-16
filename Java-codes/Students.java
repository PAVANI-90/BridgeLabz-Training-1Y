class Students {

int id;
String name;

Students() {
this(101, "Rishikesh"); // calls parameterized constructor
System.out.println("Default Constructor Called");
}

// Parameterized constructor
Students(int id, String name) {
this.id = id;
this.name = name;
System.out.println("Parameterized Constructor Called");
}

void display() {
System.out.println(id + " " + name);
}

public static void main(String[] args) {
Students s = new Student();
s.display();
}
}