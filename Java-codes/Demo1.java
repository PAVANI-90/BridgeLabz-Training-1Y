class HelloWorld {
    static int emailId;  
}

public class Demo1 {
    static int x = 50; //static variable
    int z = 60; // instance variable

    public static void m2() {
        int y = 30;  //Local variable
        System.out.println("m2 local var " + y); //uses y from m2
    }

    public static void m1() {
        int y = 20;  //local variable
        System.out.println("m1 local var " + y);// uses y from m1
        m2();  
    }

    public static void main(String[] args) {
        int y = 10;
        System.out.println("HelloWorld"); //print statement no memory storage uses cpu only.
        System.out.println("main static var x " + x); // acess static variable stored in method area, not in stack
        System.out.println("main local var y " + y);// uses y from main stack frame
        m1();

        Demo1 obj = new Demo1();
        System.out.println("instance/non-static/object-level var " + obj.z); //uses obj reference from stack & access z from heap
    }
}