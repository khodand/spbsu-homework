package group144.khodko;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * Operand class. If operator pattern chosen => shoud be more vertexes
 */
public class OperatorNode implements TreeNode {
    private char operator;
    private TreeNode left = null;
    private TreeNode right = null;

    OperatorNode(Scanner scanner) {
        String input = scanner.next();
        operator = input.charAt(input.length() - 1);

        if (scanner.hasNextInt()) {
            left = new OperandNode(scanner);
        } else {
            left = new OperatorNode(scanner);
        }
        if (scanner.hasNext(Pattern.compile("[-]?[0-9]+([)]+)?"))) {
            right = new OperandNode(scanner);
        } else {
            right = new OperatorNode(scanner);
        }

    }

    /**
     * calculating on type of operator
     */
    @Override
    public int calculate() {
        switch (operator) {
            case '+':
                return left.calculate() + right.calculate();
            case '-':
                return left.calculate() - right.calculate();
            case '*':
                return left.calculate() * right.calculate();
            case '/':
                return left.calculate() / right.calculate();
            default:
                return 0;
        }
    }

    @Override
    public void print(PrintStream stream) {
        stream.print('(');
        stream.print(operator);
        stream.print(' ');
        left.print(stream);
        stream.print(' ');
        right.print(stream);
        stream.print(')');
    }
}