package Homework2022_09_27;

/*Metod vuvodiashi vse tselue netchotnue tchisla v diapasone num1 i num2*/

public class Homework_01 {
    public static void main(String[] args) {
        int num1 = 11;
        int num2 = 11;
        printOddNumbers(num1,num2);
    }

    public static void printOddNumbers(int num1, int num2) {
        for (int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
