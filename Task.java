package com.company;

public class Task {

    public void task(LinkedList<Integer> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            if (containsOnly(list.get(i))){
                list.add(i, 0);
                list.add(i+2, 0);
                i = i+2;
            }
        }
    }

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
}
