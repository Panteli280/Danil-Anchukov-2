package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(28);
        list.add(23);
        list.task(list);
        int t = list.size();
        System.out.println(t);
    }
}
