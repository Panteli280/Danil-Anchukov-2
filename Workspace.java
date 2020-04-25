package com.devijoe.project;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Workspace<T> {

    private transient int size = 0;
    //первый элемент
    private transient Node<T> first;
    //последний элемент
    private transient Node<T> last;

    /**
     * 18.	В двусвязном списке целых чисел перед и после каждого простого числа вставить новые элементы со значением 0.
     */
    public void tusk(LinkedList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (containsOnly(list.get(i))){
                list.add(i, 0);
                list.add(i+2, 0);
                i = i+2;
            }
        }
    }

    /**
     * Присоединяет первый элемент
     */
    private void linkFirst(T t) {
        final Node<T> k = this.first;
        final Node<T> node = new Node<>(t, null, k);
        this.first = node;
        if (k==null) {
            last = node;
        } else {
            k.setPrev(node);
        }
        size++;
    }

    /**
     * Присоединяет последний элемент
     * @param t
     */
    private void linkLast(T t) {
        final Node<T> k = this.last;
        final Node<T> node = new Node<>(t, k, null);
        this.last = node;
        if (k==null) {
            first = node;
        } else {
            k.setNext(node);
        }
        size++;
    }


    /**
     * Получение кол-ва элементов списка
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Проверка списка на пустоту
     * @return
     */
    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверка на содержание простого числа в списке
     * @param o
     */
    public boolean containsOnly(Integer o) {
        if (o == 1 || o == 2) {
            return true;
        } else {
            for (int j = 2; j < o; j++) {
                if (o % j == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Добавление элемента по индексу
     */
    public void add(int index, int element) throws Exception {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> nd = first;
        do {
            nd = nd.getNext();
            counter++;
        } while (counter!=index);
        nd.setNext(new Node(element, nd, nd.getNext()));
        nd.getPrev() = nd.getPrev().getNext() = new Node();
        this.size++;
    }

    /**
     * Удаление элемента по индексу
     */
    public void remove(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> t = first;
        while (counter!=index) {
            t = t.getNext();
            counter++;
        }
        t.setPrev(t.getNext());
    }

    /**
     * Проверка на содержание объекта в списке
     */
    public boolean contains(Object o) {

        if (o==null) {
            for (Node<T> t = first; t!=null; t = t.getNext()) {
                if (t.getValue()==null) {
                    return true;
                }
            }
        } else {
            for (Node<T> t = first; t!=null; t = t.getNext()) {
                if (t.getValue().equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Добавление элемента к массиву в конец
     */
    public void add(T t) {
        linkLast(t);
    }

    /**
     * Удаление элемента
     */
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            if (o==null) {
                for (Node<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue()==null) {
                        t.getPrev().setPrev(t.getNext());
                        return true;
                    }
                }
            } else {
                for (Node<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue().equals(o)) {
                        t.getPrev().setPrev(t.getNext());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Очистка листа
     */
    public void clear() {
        first.setNext(null);
        last.setValue(null);
        last.setValue(null);
        last.setPrev(null);
        size=0;
    }

    /**
     * Получение элемента по индексу
     */
    public Object get(int index) {
        int counter = 0;
        Node<T> t = first;
        try {
            while (counter!=index) {
                t = t.getNext();
                counter++;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return t.getValue();
    }

    /**
     * Нахождение индекс первого нужного объекта
     */
    public int indexOf(Object o) {
        int count=0;
        if (contains(o)) {
            if (o==null) {
                for (Node<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue()==null) {
                        return count;
                    } else count++;
                }
            } else {
                for (Node<T> t = first; t!=null; t = t.getNext()) {
                    if (t.getValue().equals(o)) {
                        return count;
                    } else count++;
                }
            }
        }
        return -1;
    }

    /**
     * Перебор всех элементов
     */
    public void forEach(Consumer action) {
        for (Node<T> t = first; t!=null; t=t.getNext()) {
            action.accept(t);
        }
    }

    /**
     * Приведение листа к массиву
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i=0;
        for (Node<T> t = first; t != null; t = t.getNext()) {
            array[i] = t.getValue();
            i++;
        }
        return array;
    }
    
    /**
     * Создание доп.связного листа
     */
    public Workspace subList(int fromIndex, int toIndex) {
        Workspace<T> list = new Workspace<>();
        for (Node<T> t = first; t!=null; t=t.getNext()) {
            list.add((T) get(fromIndex));
        }
        return list;
    }

    /**
     * Пустой конструктор
     */
    public Workspace() {
    }
    
}