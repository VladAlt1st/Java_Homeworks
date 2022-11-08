package Homework2022_11_02.Task_02;

import java.util.Scanner;

public class UserArrayProducer implements ArrayProducer {

    @Override
    public int[] makeArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set size:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Set values:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
