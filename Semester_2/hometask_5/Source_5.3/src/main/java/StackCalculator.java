import java.util.Stack;

/**
 * Class for counts expressions.
 * This class counts expressions from received tokens.
 * */
public class StackCalculator {
    private Stack<String> stack;
    private String output;
    private boolean isClickEqually;

    /** Do start settings. */
    public StackCalculator() {
        stack = new Stack<>();
        output = new String("0");
        stack.push("0");
        isClickEqually = true;
    }

    /** Return string to output. */
    public String getOutput() {
        return output;
    }

    /**
     * Receive tokens for computing.
     * List of of allowable tokens:
     * "0".."9", "+", "-", "*", "/",
     * "=", ",", ".", "C", "c", "<-".
     *
     * @param token Input token
     *  */
    public void computing(String token) {
        char symbol = token.charAt(0);

        if (((symbol >= '0') && (symbol <= '9')) || (symbol == ',') || (symbol == '.')) {
            setNumber(symbol);
            return;
        }

        if (isOperation(symbol)) {
            setOperation(symbol);
            return;
        }

        if (symbol == '=') {
            count();
            return;
        }

        if ((symbol == 'C') || (symbol == 'c')) {
            clean();
            return;
        }

        deleteSymbol();
    }

    private boolean isOperation(char symbol) {
        return (symbol == '+') || (symbol == '-') || (symbol == '*') || (symbol == '/');
    }

    private void setNumber(char symbol) {
        if (isClickEqually) {
            stack.clear();
            output = "";
            isClickEqually = false;
        }

        if ((symbol == ',') || (symbol == '.')) {
            if (stack.empty() || isOperation(stack.peek().charAt(0))) {
                stack.push("0.");
                output += "0.";
                return;
            }

            if (!stack.peek().contains(".")) {
                stack.push(stack.pop() + ".");
                output += ".";
            }

            return;
        }

        if (stack.empty() || isOperation(stack.peek().charAt(0))) {
            stack.push(Character.toString(symbol));
            output += symbol;
            return;
        }

        stack.push(stack.pop() + symbol);
        output += symbol;
    }

    private void setOperation(char symbol) {
        String prevToken = stack.peek();

        if (prevToken.charAt(prevToken.length() - 1) == '.') {
            prevToken = prevToken.substring(0, prevToken.length() - 1);
            stack.pop();
            stack.push(prevToken);
            output = output.substring(0, output.length() - 1);
        }

        if (isOperation(prevToken.charAt(0))) {
            stack.pop();
            output = output.substring(0, output.length() - 3);
        }

        count();
        isClickEqually = false;

        switch (symbol) {
            case '+':
                stack.push("+");
                output += " + ";
                break;
            case '-':
                stack.push("-");
                output += " - ";
                break;
            case '*':
                stack.push("*");
                output += " * ";
                break;
            case '/':
                stack.push("/");
                output += " / ";
                break;
        }
    }

    private void count() {
        if (isOperation(stack.peek().charAt(0))) {
            return;
        }

        String secondValue = stack.pop();
        isClickEqually = true;
        if (stack.empty()) {
            stack.push(secondValue);
            return;
        }

        char operation = stack.pop().charAt(0);
        String firstValue = stack.pop();
        float firstNumber = Float.parseFloat(firstValue);
        float secondNumber = Float.parseFloat(secondValue);
        float result = 0;

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
        }

        if ((operation == '/') || firstValue.contains(".") || secondValue.contains(".")) {
            stack.push(Float.toString(result));
            output = stack.peek();
        } else {
            stack.push(Integer.toString((int)result));
            output = stack.peek();
        }
    }

    private void clean() {
        stack.clear();
        stack.push("0");
        output = "0";
        isClickEqually = true;
    }

    private void deleteSymbol() {
        String prevToken = stack.peek();

        if (isClickEqually || isOperation(prevToken.charAt(0))) {
            return;
        }

        if (prevToken.length() == 1) {
            stack.pop();
            output = output.substring(0, output.length() - 1);
            if (stack.empty()) {
                clean();
            }
            return;
        }

        prevToken = prevToken.substring(0, prevToken.length() - 1);
        stack.pop();
        stack.push(prevToken);
        output = output.substring(0, output.length() - 1);
    }
}