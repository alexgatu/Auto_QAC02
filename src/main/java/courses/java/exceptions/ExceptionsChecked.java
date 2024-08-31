package courses.java.exceptions;

public class ExceptionsChecked {

    public static void main(String[] args) {

        try {
            double radius = Double.parseDouble(args[0]);
            System.out.println("Aria cercului este" + Areas.getCircleArea(radius));

            double side = Double.parseDouble(args[1]);
            System.out.println("Aria patratului este" + Areas.getSquareArea(side));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide a radius value as runtime argument");
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid number as radius value, error found:" + e.getMessage());
        } catch (IllegalArgumentException | MyCustomException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error unchecked exception:" + e.getMessage());
        } finally {
            //always run
            System.out.println("Clean up: Close browser at the end");
        }
    }
}
