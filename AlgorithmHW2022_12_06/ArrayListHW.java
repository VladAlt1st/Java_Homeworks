package AlgorithmHW2022_12_06;

public class ArrayListHW {

    private int capacity;
    private int size;
    private int[] arr;

    public ArrayListHW(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public ArrayListHW() {
        this.capacity = 10;
        arr = new int[capacity];
    }

    public void add(int value) {
        if (size == capacity) {
            enlarge();
        }
        arr[size++] = value;
    }

    public void addAt(int index, int value) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            enlarge();
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    private void enlarge() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void remove() {
        arr[--size] = 0;
    }

    public void removeAt(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size - 1) {
            remove();
            return;
        }
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
    }

    public void set(int index, int value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = value;
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        capacity = 10;
        size = 0;
        arr = new int[capacity];
    }

    public void shrinkSize() {
        capacity = size;
        int[] newArr = new int[capacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}
