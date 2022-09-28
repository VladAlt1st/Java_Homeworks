package Homework2022_09_27;

/*Metod vuvodiashi vse tselue tchisla v diapasone num1 i num2
s vuvodom esli delitsa na dva ili tri*/

public class Homework_02 {
    public static void main(String[] args) {
        int num1 = -10;
        int num2 = 1;
        printNumbers(num1,num2);
    }

    public static void printNumbers(int num1, int num2) {
        for (int i = Math.min(num1,num2); i <= Math.max(num1,num2); i++) {
            if (i % 2 == 0 && i % 3 == 0 && i != 0) {
                System.out.println(i + " divided by two and three");
            } else if (i % 2 == 0 && i != 0) {
                System.out.println(i + " divided by two");
            } else if (i % 3 == 0 && i != 0) {
                System.out.println(i + " divided by three");
            } else {
                System.out.println(i);
            }
        }
    }
}
