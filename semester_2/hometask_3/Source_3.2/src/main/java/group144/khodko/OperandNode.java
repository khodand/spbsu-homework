package group144.khodko;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Operand class. If operand pattern chosen => external vertex
 */
public class OperandNode implements TreeNode {
    private int value;

    OperandNode(Scanner scanner) {
        String input = scanner.next();
        if (input.charAt(input.length() - 1) == ')') {
            value = Integer.parseInt(input.substring(0, input.indexOf(')')));
        } else {
            value = Integer.parseInt(input);
        }
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public void print(PrintStream stream) {
        stream.print(value);
    }
}