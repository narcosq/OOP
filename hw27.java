class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Division by zero is not allowed.");
    }
}

class Calculator {
    public double divide(double numerator, double denominator) throws DivisionByZeroException {
        try {
            if (denominator == 0) {
                throw new DivisionByZeroException();
            }
            return numerator / denominator;
        } catch (DivisionByZeroException e) {
            throw e;
        }
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        try {
            // Create a Calculator object
            Calculator myCalculator = new Calculator();

            // Perform a division operation where the denominator is zero
            double numerator = 10;
            double denominator = 0;
            double result = myCalculator.divide(numerator, denominator);
            System.out.println("Result: " + result);

        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
