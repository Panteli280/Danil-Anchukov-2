package com.company;

public class Node {

    private int value;
    Node next;
    Node prev;

    public Node(int value, Node prev, Node next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public Node(int value) {
        this(value, null, null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
