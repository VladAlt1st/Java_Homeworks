package Homework2022_09_20;

public class Homework_01 {
    public static void main(String[] args) {
        int a = 8;
        int b = 5;
        int c = 13;
        System.out.println(checkNumberEquality(a,b,c));
        printNumberEquality(a, b, c);
    }

    public static boolean checkNumberEquality(int a, int b, int c) {
       return a == b + c || b == a + c || c == a + b;
    } // вариант с простой проверкой

    public static  void printNumberEquality(int a, int b, int c) {
        if (a == b + c) {
            System.out.printf("%d is the sum of %d and %d", a , b, c);
        } else if (b == a + c) {
            System.out.printf("%d is the sum of %d and %d", b, a, c);
        } else if (c == a + b) {
            System.out.printf("%d is the sum of %d and %d", c, a, b);
        } else {
            System.out.println("there is no number equal to the sum of the other two");
        } // вариант с проверкой и выводом
    }
}