// Abstract class
abstract class Shape {

    // Abstract method (no body)
    abstract void calculateArea();

    // Normal method, Concrete, Non-abstract
    void display() {
        System.out.println("This is a shape");
    }
}

// Child class 1
class Circle extends Shape {
    int radius = 5;

    void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

// Child class 2
class Rectangle extends Shape {
    int length = 4, width = 6;

    void calculateArea() {
        int area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Main class
class TestAbstraction {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.display();
        c.calculateArea();

        Rectangle r = new Rectangle();
        r.calculateArea();
    }
}

