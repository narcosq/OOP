<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox alignment="TOP_CENTER" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1">
    <children>
        <TextField fx:id="inputField" alignment="CENTER" disable="false" editable="true" prefHeight="40.0" prefWidth="600.0" promptText="0" />
        <HBox spacing="5.0">
            <children>
                <!-- Digit buttons -->
                <Button text="1" onAction="#handleDigit" />
                <Button text="2" onAction="#handleDigit" />
                <!-- Add buttons for other digits -->
            </children>
        </HBox>
        <HBox spacing="5.0">
            <children>
                <!-- Operator buttons -->
                <Button text="+" onAction="#handleOperator" />
                <Button text="-" onAction="#handleOperator" />
                <!-- Add buttons for other operators -->
                <Button text="=" onAction="#handleEquals" />
            </children>
        </HBox>
        <Button text="Clear" onAction="#handleClear" />
    </children>
</VBox>

public class Calculator {
    private double operand1;
    private double operand2;
    private char operator;
    private double result;

    public void setOperand1(double operand) {
        this.operand1 = operand;
    }

    public void setOperand2(double operand) {
        this.operand2 = operand;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void calculate() {
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    result = Double.NaN; // Handle division by zero
                }
                break;
        }
    }

    public double getResult() {
        return result;
    }
}

public void handleDigit(ActionEvent event) {
    Button button = (Button) event.getSource();
    String digit = button.getText();
    inputField.appendText(digit);
}

public void handleOperator(ActionEvent event) {
    Button button = (Button) event.getSource();
    char op = button.getText().charAt(0);
    calculator.setOperand1(Double.parseDouble(inputField.getText()));
    calculator.setOperator(op);
    inputField.clear();
}

public void handleEquals(ActionEvent event) {
    calculator.setOperand2(Double.parseDouble(inputField.getText()));
    calculator.calculate();
    double result = calculator.getResult();
    inputField.setText(String.valueOf(result));
}

public void handleClear(ActionEvent event) {
    inputField.clear();
}
