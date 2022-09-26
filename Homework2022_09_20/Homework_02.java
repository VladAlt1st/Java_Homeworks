package Homework2022_09_20;

public class Homework_02 {
    public static void main(String[] args) {
        double speed = 134;
        double speedLimit = 90;
        printPenalty(penalty(speed, speedLimit));
    }

    public static void printPenalty(int penalty) {
        System.out.printf("the penalty is %d euros", penalty);
    }

    public static int penalty(double speed, double speedLimit) {
        double overSpeed = (speed - speedLimit);
        double tenPercent =  speedLimit / 100 * 10;
        double twentyPercent = speedLimit / 100 * 20;
        double thirtyPercent = speedLimit / 100 * 30;
        int penalty = 0;
        if (overSpeed >= tenPercent && overSpeed < twentyPercent) {
            penalty = 50;
        } else if (overSpeed >= twentyPercent && overSpeed < thirtyPercent) {
            penalty = 150;
        } else if (overSpeed >= thirtyPercent) {
            penalty = 500;
        }
        return penalty;
    }
}
