package group144.khodko;

import java.io.*;
import java.util.Scanner;

public class CountsTree {
    private class Operand {
        private char token;

        private Operand left = null;
        private Operand right = null;

        Operand() { }

        private int count() {
            if (!isNumber())
                return binOperation(left.count(), right.count(), token);
            else
                return token - '0';
        }

        private void print(PrintStream outs) {
                if (isNumber()) {
                    outs.print(" ");
                    outs.print(token - '0');
                }
                else {
                    outs.print(" (");
                    outs.print(token);
                    left.print(outs);
                    right.print(outs);
                    outs.print(") ");
                }
        }

        private Integer binOperation(Integer a, Integer b, char operator) {
            switch (operator) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    return a / b;
            }
            return 0;
        }

        private boolean isNumber() {
            return token >= '0' && token <= '9';
        }

        private void input(String input, int[] start){
            int i = start[0];

            while (input.charAt(i++) == ' ');
            token = input.charAt(i - 1); // readed '(' or digit

            if (!isNumber()) {
                while (input.charAt(i++) == ' ');

                token = input.charAt(i - 1);

                while (input.charAt(i++) == ' ');

                left = new Operand();
                right = new Operand();

                start[0] = i - 1;
                left.input(input, start);
                right.input(input, start);

                while (input.charAt(start[0]++) == ' ');
            }
            else
                start[0] = i;
        }

    }

    private Operand root = new Operand();

    OperandTree() { }

    public void print(PrintStream outs) {
        root.print(outs);
    }

    public int count() {
        return root.count();
    }

    public void input(InputStream ins) {
        Scanner input =  new Scanner(ins);
        int[] start = new int[1];
        root.input("(+ 1 1)", start);
    }


}
