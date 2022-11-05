package Homework2022_11_02.Task_02;

import java.util.Scanner;

public class Production {

    public static int[] getArray(){
        printInfo();
        Arrayable arrayable = setArrayType();
        return arrayable.makeArray();
    }

    private static void printInfo() {
        System.out.println("Enter array type:\n" +
                "1. Integer array;\n" +
                "2. Double array;\n" +
                "3. String array.");
    }

    private static Arrayable setArrayType() {
        return switch (setWay()) {
            case 1 -> new UnitsArray();
            case 2 -> new TensArray();
            case 3 -> new HundredsArray();
            default -> null;
        };
    }

    private static int setWay() {
        Scanner sc = new Scanner(System.in);
        int way = sc.nextInt();
        while (way < 1 || way > 3) {
            way = sc.nextInt();
        }
        return way;
    }
}
