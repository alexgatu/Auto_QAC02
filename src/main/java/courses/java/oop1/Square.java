package courses.java.oop1;

public class Square {
    private int side;

    //    default constructor
    public Square() {
    }

    // custom constructor
    public Square(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public double getArea() {
        return this.calculateArea(side);
    }

    public void draw() {
//    using other object method on current class
        Draw.drawSquare(side);
    }

    protected double getPerimeter() {
        return 4 * side;
    }

    private double calculateArea(int side) {
        System.out.println("Calculate square area for side:" + side);
        return side * side;
    }
}
