package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        Workspace<Integer> list = new Workspace<>();
        list.add(1);
        list.add(2);
        list.add(28);
        list.add(23);
        list.tusk(list);
        int t = list.size();
        System.out.println(t);
    }
}
