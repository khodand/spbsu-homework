package group144.khodko;

import java.io.*;
import java.util.Scanner;

/**
 * Class gets next token and use operand or operator pattern
 */
public class CountsTree {
    private TreeNode root;

    CountsTree(Scanner in) {
        if (in.hasNextInt())
            root = new OperandNode(in);
        else
            root = new OperatorNode(in);
    }

    public void print(PrintStream outs) {
        root.print(outs);
    }

    public int count() {
        return root.calculate();
    }
}