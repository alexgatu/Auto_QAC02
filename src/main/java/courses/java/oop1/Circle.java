package courses.java.oop1;

//class has default access modifier - > package-private
class Circle {
    private double radius;
    private final double PI = 3.14159;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.PI * this.radius * this.radius;
    }
}
