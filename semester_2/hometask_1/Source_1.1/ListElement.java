package com.group144.khodko;

public class ListElement {
    int value;
    ListElement next;

    ListElement() { }

    ListElement(int value, ListElement next) {
        this.next = next;
        this.value = value;
    }
}
