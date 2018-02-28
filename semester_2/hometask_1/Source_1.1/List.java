package com.group144.khodko;

public class List {

    private class ListElement {
        int value;
        ListElement next;

        ListElement() { }

        ListElement(int value, ListElement next) {
            this.next = next;
            this.value = value;
        }
    }

    private ListElement first = null;
    private int size = 0;

    List() { }

    List(int value) {
        first = new ListElement(value, null);
        size = 1;
    }

    List(ListElement first) {
        this.first = first;
        size = 1;
    }

    public void add(int value) {
        first = new ListElement(value, first);
        size++;
    }

    public void remove(int i) {
        if (i >= size || i < 0)
            return;

        size--;
        ListElement cur = first;
        ListElement prev = cur;
        if (i == 0) {
            first = first.next;
            return;
        }

        while (i != 0) {
            prev = cur;
            cur = cur.next;
            i--;
        }
        prev.next = cur.next;
    }

    public int get(int i){
        if (i >= size || i < 0)
            return -404;

        ListElement cur = first;
        while (i != 0) {
            cur = cur.next;
            i--;
        }

        return cur.value;
    }

}
