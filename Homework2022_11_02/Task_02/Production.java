package Homework2022_11_02.Task_02;

import java.util.Scanner;

public class Production {

    public int[] getArray() {
        System.out.println("Enter array type:\n" +
                "1. Static array;\n" +
                "2. Random array;\n" +
                "3. User array.");
        return switch (setChose()) {
            case 1 -> getArray(new StaticArrayProducer());
            case 2 -> getArray(new RndArrayProducer());
            case 3 -> getArray(new UserArrayProducer());
            default -> new int[0];
        };
    }

    public int[] getArray(ArrayProducer arrayProducer){
       return arrayProducer.makeArray();
    }

    private int setChose() {
        Scanner sc = new Scanner(System.in);
        int chose = sc.nextInt();
        while (chose < 1 || chose > 3) {
            chose = sc.nextInt();
        }
        return chose;
    }
}
