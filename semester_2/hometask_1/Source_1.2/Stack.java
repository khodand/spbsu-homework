package com.group144.khodko;

public class Stack {

    private class StackElement {
        int value;
        StackElement next;

        StackElement(int value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackElement head = null;

    Stack() { }

    Stack(int value) {
        head = new StackElement(value, null);
    }

    public void push(int value) {
        head = new StackElement(value, head);
    }

    public int pop() {
        if (head == null)
            return -404;
        int result = head.value;
        head = head.next;
        return result;
    }

    public int top() {
        if (head == null)
            return -404;
        return head.value;
    }
}
