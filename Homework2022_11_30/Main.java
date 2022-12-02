package Homework2022_11_30;

public class Main {
    public static void main(String[] args) {
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.add(0, 0);
        linkedList.add(3, 4);

        System.out.println(linkedList.remove(1));
        System.out.println(linkedList.get(1));

        linkedList.printData();
    }
}
