package com.group144.khodko;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }

        System.out.println(stack.top());

        for (int i = 0; i < 10; ++i) {
            System.out.print(stack.pop());
        }
    }
}
