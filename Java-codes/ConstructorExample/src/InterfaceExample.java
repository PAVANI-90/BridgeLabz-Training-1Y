//public interface InterfaceExample {
//void display ();
//}
public interface InterfaceExample {
    default void display() {
        show();
        System.out.println("Default method");
    }
    private void show(){
        System.out.println("private Method ");
    }
}