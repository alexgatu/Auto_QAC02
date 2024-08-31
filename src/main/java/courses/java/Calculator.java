package courses.java;

public class Calculator {
    public double compute(double firstParam, double secondParam, String operator)
            throws IllegalArgumentException {
        double result;
        switch (operator) {
            case "+":
                result = firstParam + secondParam;
                break;
            case "-":
                result = firstParam - secondParam;
                break;
            case "*":
                result = firstParam * secondParam;
                break;
            case "/":
                if (secondParam == 0) {
                    throw new IllegalArgumentException("Divide by ZERO");
                } else {
                    result = firstParam / secondParam;
                }
                break;
            case "SQRT":
                result = Math.sqrt(firstParam);
                break;
            default: {
                throw new IllegalArgumentException("UNSUPPORTED OPERATOR: " + operator);
            }
        }
        return result;
    }
}
