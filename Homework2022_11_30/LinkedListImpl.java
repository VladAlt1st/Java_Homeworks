package Homework2022_11_30;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean add(T elem) {
        Node<T> newNode = new Node<>(elem);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
        return true;
    }

    public void add(int index, T elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(elem);

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }

        if (index == size) {
            add(elem);
            return;
        }

        Node<T> res = findByIndex(index);

        res.prev.next = newNode;
        newNode.prev = res.prev;

        res.prev = newNode;
        newNode.next = res;

        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> res = findByIndex(index);

        if (index == 0) {
            head = head.next;
            head.prev = null;
            res.next = null;
            size--;
            return res.data;
        }

        if (index == size - 1) {
            res = tail;
            tail = tail.prev;
            tail.next = null;
            res.prev = null;
            size--;
            return res.data;
        }

        res.prev.next = res.next;
        res.next.prev = res.prev;

        res.prev = null;
        res.next = null;
        size--;
        return res.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return head.data;
        }

        if (index == size - 1) {
            return tail.data;
        }

        Node<T> res = findByIndex(index);

        return res.data;
    }

    private Node<T> findByIndex(int index) {
        Node<T> res = head;

        if (index <= size / 2){
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
        }

        if (index > size / 2) {
            res = tail;
            for (int i = size - 1; i > index; i--) {
                res = res.prev;
            }
        }
        return res;
    }

    public void printData() {
        if (head == null) {
            System.out.println("LinkedList is empty.");
        } else {
            Node<T> currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new OurIterator(this);
    }

    class OurIterator implements Iterator<T> {
        private LinkedListImpl<T> list;
        private int pos = 0;

        public OurIterator(LinkedListImpl<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return pos < list.size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return list.get(pos++);
        }

        @Override
        public void remove() {
            if (!(pos > 0 && pos <= size)) {
                throw new NoSuchElementException();
            }
            list.remove(--pos);
        }
    }

    private static class Node<T> {
        private Node<T> prev;
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
