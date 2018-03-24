package group144.khodko;

public class Calculator {

    private Stack<Integer> operands = new LinkedStack<Integer>();

    Calculator() {}

    Calculator(ArrayStack<Integer> stack) {
        operands = stack;
    }

    Calculator(LinkedStack<Integer> stack) {
        operands = stack;
    }

    public int calculate(String input) throws WrongInputException {
        while (!operands.isEmpty())
            operands.pop();

        String[] tokens = input.split(" ");

        try {
            for (String token : tokens) {
                if (isNumber(token))
                    operands.push(Integer.parseInt(token));
                else {
                    int secondOperand = operands.pop();
                    int firstOperand = operands.pop();
                    operands.push(binOperation(firstOperand, secondOperand, token));
                }
            }
        }
        catch (EmptyStackException id0) {
            throw new WrongInputException("Not enough operands in front of operator!");
        }

        return operands.pop();
    }


    private Integer binOperation(Integer a, Integer b, String operator) throws WrongInputException {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        throw new WrongInputException("Input is incorrect!");
    }


    private boolean isNumber(String string) {
        for (int i = 0; i < string.length(); ++i) {
            if(!(string.charAt(i) >= '0' && string.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

}
