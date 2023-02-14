package Homework2023_02_14;

import java.util.*;

public class GenericList<T> {
    private final int maxCapacity;
    private int size;
    private List<T> list;

    public GenericList(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        list = new ArrayList<>(maxCapacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T t) {
        for (T e : list) {
            if (e.equals(t)){
                return true;
            }
        }
        return false;
    }

    public boolean add(T t) {
        if (size >= maxCapacity) {
            return false;
        }
        list.add(size++, t);
        return true;
    }


    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(index);
    }

    public boolean remove(T t) {
        for (int i = 0; i < list.size(); i++) {
            if (t.equals(list.get(i))) {
                list.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        list = new ArrayList<>(maxCapacity);
    }
}
