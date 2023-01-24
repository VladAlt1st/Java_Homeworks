package Homework2022_11_30;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);

       /* linkedList.add(0, 0);
        linkedList.add(3, 4);

        System.out.println(linkedList.remove(9));
        System.out.println(linkedList.get(1));

        linkedList.printData();*/

        for (Integer i : linkedList) {

        }

        Iterator<Integer> itr = linkedList.iterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if (i % 2 == 0) {
                System.out.println(i);
                itr.remove();
            }
        }
    }
}
