package Homework2022_10_05;

//Method that returns the name of the best student

public class Homework_01 {
    public static void main(String[] args) {
        String[] students = {"John", "Vlad", "Anna", "Kate"};
        double[] grades = {4.3, 3.6 , 4.7, 4.0};
        System.out.println(findBestStudent(students, findIndexOfBestGrade(grades)));
    }

    public static int findIndexOfBestGrade(double[] grades) {
        double maxGrade = 0;
        int index = 0;
        for (int i = 0; i < grades.length; i++) {
            if (maxGrade < grades[i]) {
                maxGrade = grades[i];
                index = i;
            }
        }
        return index;
    }

    public static String findBestStudent(String[] students, int index) {
        return students[index];
    }

    /* Single method option
    public static String findBestStudent(String[] students, double[] grades) {
        double maxGrade = 0;
        String bestStudent = null;
        for (int i = 0; i < grades.length; i++) {
            if (maxGrade < grades[i]) {
                maxGrade = grades[i];
                bestStudent = students[i];
            }
        }
        return bestStudent;
    }*/
}
