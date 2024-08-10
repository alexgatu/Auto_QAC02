package courses.java.oop2;

public class Utils {

    public static int value = 100;

    // Static - needs to be called from the class
    public static void printCircleStatic(Circle c) {
        System.out.println("Color: " + c.getColor());
        System.out.println("Vertices count: " + c.getVertices());
        System.out.println("Radius: " + c.getRadius());
        System.out.println("---------");
    }
}
