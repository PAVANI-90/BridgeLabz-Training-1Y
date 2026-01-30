public class Student {

    
    int id;
    String name;
    int age;

   
    void displayDetails() {
		String status= "Active";
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Student Age  : " + age);
		System.out.println("Student Status  : " + status);

    }

  
    public static void main(String[] args) {

        
        Student s1 = new Student();

       
        s1.id = 101;
        s1.name = "Rahul";
        s1.age = 20;

       
        s1.displayDetails();
    }
}