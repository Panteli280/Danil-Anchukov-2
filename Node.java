package com.company;

public class Node<Integer> {

    private Integer value;
    Node<Integer> next;
    Node<Integer> prev;

    public Node(Integer value, Node<Integer> prev, Node<Integer> next) {
        this.value = value;
        this.next = next;
    }

    public Node(Integer value) {
        this(value, null, null);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node<Integer> getNext() {
        return next;
    }

    public void setNext(Node<Integer> next) {
        this.next = next;
    }

    public Node<Integer> getPrev() {
        return prev;
    }

    public void setPrev(Node<Integer> prev) {
        this.prev = prev;
    }
}
