package com.group144.khodko;

public class StackElement {
    private int value;
    private StackElement next;

    StackElement(int value, StackElement next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public StackElement getNext() {
        return next;
    }
}
