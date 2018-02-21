package com.group144.khodko;

public class List {
    private ListElement first;

    List() {
        this.first = null;
    }

    List(int value) {
        this.first = new ListElement(value, null);
    }

    List(ListElement first) {
        this.first = first;
    }

    public void add(int value) {
        this.first = new ListElement(value, this.first);
    }

    public void remove(int i) {
        ListElement cur = this.first;
        ListElement prev = cur;
        if (i == 0) {
            this.first = this.first.getNext();
            return;
        }

        while (i != 0) {
            if (cur == null)
                return;
            prev = cur;
            cur = cur.getNext();
            i--;
        }
        prev.setNext(cur.getNext());
    }

    public int get(int i){
        ListElement cur = this.first;
        while (i != 0 && cur.getNext() != null) {
            cur = cur.getNext();
            i--;
        }

        return cur.getValue();
    }
}
