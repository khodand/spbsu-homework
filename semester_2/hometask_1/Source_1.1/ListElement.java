package com.group144.khodko;

public class ListElement {
    private int value;
    private ListElement next;

    ListElement() { }

    ListElement(int value, ListElement next) {
        this.next = next;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next){
        this.next = next;
    }
}
