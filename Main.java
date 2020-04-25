package com.devijoe.project;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        Workspace<Integer> list = new Workspace<>();
        list.add(1);
        list.add(2);
        list.add(28);
        list.add(2,3);
        list.tusk(list);
        int t = list.size();
        System.out.println(t);
    }
}