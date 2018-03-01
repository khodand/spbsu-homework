package group144.khodko;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  WrongInputException{
        System.out.println("Enter an expression in postfix notation:");
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();

        Calculator calculator = new Calculator();

        System.out.println("Result: ");
        System.out.println(calculator.calculate(expression));
    }
}
