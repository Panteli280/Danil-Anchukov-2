package com.devijoe.project;

public class Node<T> {

    //Значение поля
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node(T value, Node<T> prev, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this(value, null, null);
    }

    public Node() {
        this(null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
