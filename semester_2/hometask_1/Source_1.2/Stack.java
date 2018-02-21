package com.group144.khodko;

public class Stack {
    private StackElement head;

    Stack() { }

    Stack(int value) {
        head = new StackElement(value, null);
    }

    public void push(int value) {
        head = new StackElement(value, head);
    }

    public int pop() {
        int result = head.getValue();
        head = head.getNext();
        return result;
    }

    public int top() {
        return head.getValue();
    }
}
