package com.company;

import java.util.function.Consumer;

public class LinkedList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    /**
     * 18.	В двусвязном списке целых чисел перед и после каждого простого числа вставить новые элементы со значением 0.
     */

    /**
     * (с) "сделан нелогично и не правильно." Какие вопросы могут быть к пустому конструктору? 
     */
    public Workspace() {
    }

     public void add(T t) {
        linkLast(t);
    }
    
    /**
     * может add и не предполагает индекс, но конкретно этот как раз его и должен спрашивать. И в стандартной библиотеке java, к слову, оба метода одинаково названы
     */
    public void addIndex(int index, int element) {
           if (index > size || index < 0) {
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
     * (с) "зачем этот метод? Он ни к селу не к городу." Вот вообще не понимаю. И метод хороший - проверять значение по индексу иногда очень нужно. И даже в библиотеке java он есть
     */
        public T getIndex(int index) {
            if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> t = first;
            while (counter!=index) {
                t = t.getNext();
                counter++;
            }
        return  t.getValue();
    }
    
       public void remove(int index) {
         if (index > size || index < 0) {
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
     * Удаление конкретного элемента
     */
    public boolean remove(Object o) {
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

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверка на содержание простого числа в списке
     */
    public boolean containsOnlySimple(Integer o) {
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
     * туск это бивень. А бивень, как известно, это опечатка в слове таск :3
     */
     public void task(Workspace<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (containsOnly(list.get(i))){
                list.add(i, 0);
                list.add(i+2, 0);
                i = i+2;
            }
        }
    }

    public void clear() {
        first.setNext(null);
        last.setValue(null);
        last.setPrev(null);
        size=0;
    }
    
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


    public void forEach(Consumer action) {
        for (Node<T> t = first; t!=null; t=t.getNext()) {
            action.accept(t);
        }
    }

   
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i=0;
        for (Node<T> t = first; t != null; t = t.getNext()) {
            array[i] = t.getValue();
            i++;
        }
        return array;
    }
}
