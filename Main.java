package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(0);
        list.add(28);
        list.add(1);
        list.task(list);
        int[] array = list.toArray();
    }
}
