package group144.khodko;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

/**
 * Controller for UI FXML file
 */

public class Controller {

    @FXML
    public Text firstValue;

    @FXML
    public Text secondValue;

    @FXML
    public Text resultValue;

    @FXML
    ChoiceBox operator = new ChoiceBox();

    /**
     * Initialization method
     */
    @FXML
    public void initialize() {
        firstValue.setText("0");
        secondValue.setText("0");
        resultValue.setText("0");

        operator.getItems().addAll("+","-","*","/");
        operator.setValue("+");
    }

    /**
     * Calculate method, starting on operator changes and etc
     */
    public void calculate() {
        int leftOperand = Integer.parseInt(firstValue.getText());
        int rightOperand = Integer.parseInt(secondValue.getText());

        int result = 0;
        switch (String.valueOf(operator.getValue())) {
            case "+":
                result = leftOperand + rightOperand;
                break;

            case "-":
                result = leftOperand - rightOperand;
                break;

            case "*":
                result = leftOperand * rightOperand;
                break;

            case "/":
                result = leftOperand / rightOperand;
                break;

            default:
                System.out.println(":thinking:");

        }
        resultValue.setText(String.valueOf(result));
    }


    /**
     * Methods for inc and dec operands, calculate() after any action
     */
    public void incrementFirstAction(ActionEvent actionEvent) {
        int operand = Integer.parseInt(firstValue.getText());
        operand++;
        firstValue.setText(String.valueOf(operand));

        calculate();
    }

    public void decrementFirstAction(ActionEvent actionEvent) {
        int operand = Integer.parseInt(firstValue.getText());
        operand--;
        firstValue.setText(String.valueOf(operand));

        calculate();
    }

    public void incrementSecondAction(ActionEvent actionEvent) {
        int operand = Integer.parseInt(secondValue.getText());
        operand++;
        secondValue.setText(String.valueOf(operand));

        calculate();
    }

    public void decrementSecondAction(ActionEvent actionEvent) {
        int operand = Integer.parseInt(secondValue.getText());
        operand--;
        secondValue.setText(String.valueOf(operand));

        calculate();
    }

}
