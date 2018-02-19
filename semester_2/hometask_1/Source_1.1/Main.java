package com.group144.khodko;

public class Main {

    public static void main(String[] args) {
        List list = new List();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        for (int i = 0; i < 10; ++i) {
            System.out.print(list.get(i));
        }
        System.out.println();
        list.remove(0);
        list.remove(3);
        for (int i = 0; i < 10; ++i) {
            System.out.print(list.get(i));
        }
    }
}
