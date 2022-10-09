package Homework2022_10_05;

//Method outputs a string for all students whose score is higher then the given value

public class Homework_02 {
    public static void main(String[] args) {
        String[] students = {"John", "Vlad", "Anna", "Kate"};
        double[] grades = {4.3, 3.6 , 4.7, 4.1};
        double limitValue = 4.0;
        printStudentsInfo(grades, students, limitValue);
    }

    public static void printStudentsInfo(double[] grades, String[] students, double limitValue) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > limitValue) {
                System.out.printf("%s - %.1f;", students[i], grades[i]);
            }
        }
        System.out.println();
    }
}
