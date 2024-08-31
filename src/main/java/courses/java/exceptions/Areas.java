package courses.java.exceptions;

public class Areas {

    public static double getCircleArea(double radius) throws IllegalArgumentException {
        if (radius < 0)
            throw new IllegalArgumentException("Radius should be a positive value");
        return Math.PI * radius * radius;
    }

    public static double getSquareArea(double side) throws MyCustomException {
        if (side < 0)
            throw new MyCustomException("Side should be a positive value");
        return side * side;
    }
}
