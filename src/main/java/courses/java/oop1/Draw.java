package courses.java.oop1;

public class Draw {

    public static void drawFullShape(int width, int height) {
        for (int i = 0; i < width; i++) {
            drawFullLine(height);
//          create new line
            System.out.println();
        }
    }

    public static void drawSquare(int squareSide) {
        printShapeName("Square");
        drawShapeOutline(squareSide, squareSide, " ");
    }

    //    overloding method
    public static void drawShapeOutline(int width, int height) {
        drawShapeOutline(width, height, "-");
    }

    public static void drawShapeOutline(int width) {
        drawShapeOutline(width, width, "-");
    }

    public static void drawShapeOutline(int width, int height, String separator) {
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) drawFullLine(height);
            else drawOutlineLine(height, separator);
//          create new line
            System.out.println();
        }
    }

    public static void drawFullLine(int height) {
        for (int j = 0; j < height; j++)
            System.out.print("*");
    }

    public static void drawOutlineLine(int height, String emptyElement) {
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) System.out.print("*");
            else System.out.print(emptyElement);
        }
    }

    public static void printShapeName(String shapeName) {
        System.out.println("+++++++++++" + shapeName + "+++++++++++");
    }
}
