package com.company;

import java.util.function.Consumer;

public class LinkedList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

   /**
     * 18.	В двусвязном списке целых чисел перед и после каждого простого числа вставить новые элементы со значением 0.
     */

    public LinkedList() {
    }

     public void add(T t) {
        linkLast(t);
    }
    
   /**
     * (с) "add - не предполагает наличие индекса" 
     */
    
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
           }
        if (index == size) {
            add(element);
        }
        Node oldElement = getLinkByIndex(index);
        Node newElement = new Node(element, oldElement.prev, oldElement);
        if (oldElement.prev == null) {
            first = newElement;
            last = oldElement;
        } else {
            oldElement.prev.next = newElement;
            oldElement.prev = newElement;
        }
        size++;
    }
    
   /**
     * (с) "зачем этот метод? Он ни к селу не к городу." 
     */
        public T get(int index) {
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

  private Node<T> getLinkByIndex(int index) {
        Node<T> result;
        if (size >> 1 >= index) {
            result = first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = last;
            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }

   /**
     * (с)"Сделан нелогично и не правильно." Работает и взят с оригинального
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
    
       public void task(LinkedList<Integer> list) throws Exception {
       for (int i = 0; i < list.size; i++){
            if (isSimple(list.get(i))) {
                list.add(i, 0);
                list.add(i+2, 0);
                i = i+2;
            }
       }
       }

   /**
     * Проверка на простое число. Чисто метод для таска
     */
    public boolean isSimple(Integer o) {
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
}

