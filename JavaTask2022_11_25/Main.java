package JavaTask2022_11_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("aa", "b", "c", "ddd");
        System.out.println(firstLongOrShort(strings));

        List<Integer> ints = Arrays.asList(3, 4, 7, 10, 6, 6);
        System.out.println(withoutElementsMoreThanN(ints, 6));
    }

    // task 5 from lesson
    public static String firstLongOrShort(List<String> strings) {
        int indexOfShort = -1;
        int indexOfLong = -1;
        int minLength = Integer.MAX_VALUE;
        int maxLength = 1;

        for (int i = 0; i < strings.size(); i++) {
            if(strings.get(i).length() < minLength) {
                minLength = strings.get(i).length();
                indexOfShort = i;
            }
            if(strings.get(i).length() > maxLength) {
                maxLength = strings.get(i).length();
                indexOfLong = i;
            }
        }

        return strings.get(Math.min(indexOfShort, indexOfLong));
    }

    // homework
    public static List<Integer> withoutElementsMoreThanN(List<Integer> ints, int n) {
        List<Integer> resList = new ArrayList<>();

        for (Integer i:ints) {
            if(i <= n) {
                resList.add(i);
            }
        }

        return resList;
    }
}
