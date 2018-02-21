package com.group144.khodko;

public class StackElement {
    private int value;
    private StackElement next;

    StackElement(int value, StackElement next) {
        this.value = value;
        this.next = next;
    }

    int getValue() {
        return value;
    }

    StackElement getNext() {
        return next;
    }
}
