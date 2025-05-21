package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result.
     * @param number1
     * @param number2
     * @return calculated result or null if inputs are invalid
     */
    public static Double q1Addition(String number1, String number2) {
        // Check for empty or null inputs
        if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
            return null;
        }
        
        try {
            double result = Double.valueOf(number1) + Double.valueOf(number2);
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Calculate Q2 result.
     * @param number1
     * @param number2
     * @return calculated result or null if inputs are invalid
     */
    public static Double q2Subtraction(String number1, String number2) {
        // Check for empty or null inputs
        if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
            return null;
        }
        
        try {
            double result = Double.valueOf(number1) - Double.valueOf(number2);
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    /**
     * Calculate Q3 result - multiplication.
     * @param number1
     * @param number2
     * @return calculated result or null if inputs are invalid
     */
    public static Double q3Multiplication(String number1, String number2) {
        // Check for empty or null inputs
        if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
            return null;
        }
        
        try {
            double result = Double.valueOf(number1) * Double.valueOf(number2);
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}