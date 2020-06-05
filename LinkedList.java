package com.company;

public class LinkedList {

    private int size = 0;
    private Node first;
    private Node last;

    /**
     * 18.	В двусвязном списке целых чисел перед и после каждого простого числа вставить новые элементы со значением 0.
     */

    public LinkedList() {
    }

    public void add(int t) {
        linkLast(t);
    }

    public void add(int index, int value) {
        if (index == size) {
            linkLast(value);
        } else
        if (index == 0) {
            linkFirst(value);
        } else {
            Node walker = first;
            int i = 1;
            while (i < index) {
                i++;
                walker = walker.next;
            }
            Node node = new Node(value);
            node.next = walker.next;
            walker.next.prev = node;
            walker.next = node;
            node.prev = walker;
            size++;
        }
    }

    public int get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node t = first;
        while (counter!=index) {
            t = t.getNext();
            counter++;
        }
        return (int) t.getValue();
    }

    public void remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node t = first;
        while (counter!=index) {
            t = t.getNext();
            counter++;
        }
        t.setPrev(t.getNext());
    }

    private void linkFirst(int t) {
        final Node k = this.first;
        final Node node = new Node(t, null, k);
        this.first = node;
        if (k==null) {
            last = node;
        } else {
            k.setPrev(node);
        }
        size++;
    }


    private void linkLast(int t) {
        final Node k = this.last;
        final Node node = new Node(t, k, null);
        this.last = node;
        if (k==null) {
            first = node;
        } else {
            k.setNext(node);
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        first.setNext(null);
        last.setValue(null);
        last.setPrev(null);
        size=0;
    }

    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node toAr = first;
        int i = 0;
        while (toAr.getNext() != null) {
            array[i] = (int) toAr.getValue();
            toAr = toAr.getNext();
            i++;
        }
        array[i] = (int) toAr.getValue();
        return array;
    }

    public void task(LinkedList list) throws Exception {
        for (int i = 0; i < list.size; i++){
            if (isSimple(list.get(i))) {
                list.add(i, 0);
                list.add(i+2, 0);
                i = i+2;
            }
        }
    }

    public boolean isSimple(int o) {
        if (o == 0) {
            return false;
        }
        if (o == 1 || o == 2) {
            return true;
        }
        for (int j = 2; j < o; j++) {
            if (o % j == 0) {
                return false;
            }
        }
        return true;
    }
}
