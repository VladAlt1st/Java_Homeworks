package JavaTask2022_12_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1,2,3,2,5,5,1,5,5,5,8,5,5,5};
        System.out.println(findDominantElem(ints));

        List<String> names = List.of("ivan", "maria", "kolya", "vani", "amari", "vian");
        System.out.println(anagramsList(names, "ivan"));
    }

    public static Integer findDominantElem(int[] ints) {
        Map<Integer,Integer> res = new HashMap<>();
        for (Integer i : ints) {
            res.merge(i, 1, (one, sec) -> one + 1);
            if (res.get(i) > ints.length / 2) {
                return i;
            }
        }
        return -1;
    }


    public static List<String> anagramsList(List<String> strings, String name) {
        List<String> anagramsList = new ArrayList<>();

        for (String s : strings) {
            if(isAnagram(name, s)) {
                anagramsList.add(s);
            }
        }
        return anagramsList;
    }
    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character,Integer> res = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            res.merge(char1, 1, (a, b) -> a + 1);
            res.merge(char2, -1, (a, b) -> a - 1);
        }
        return res.values().stream().allMatch(v -> v == 0);
    }
}
