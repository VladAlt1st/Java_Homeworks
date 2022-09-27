package Homework2022_09_20;

public class Homework_02 {
    public static void main(String[] args) {
        int speed = 134;
        int speedLimit = 120;
        printPenalty(calcPenalty(speed, speedLimit));
    }

    public static void printPenalty(int penalty) {
        System.out.printf("the penalty is %d euros", penalty);
    }

    public static int calcPenalty(int speed, int speedLimit) {
        if (speed >= speedLimit * 1.1 && speed < speedLimit * 1.2) {
            return  50;
        } else if (speed >= speedLimit * 1.2 && speed < speedLimit * 1.3) {
            return  150;
        } else if (speed >= speedLimit * 1.3) {
            return  500;
        }
        return 0;
    }
}
