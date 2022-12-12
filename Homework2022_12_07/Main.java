package Homework2022_12_07;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        //1
        getWordsWithCount("Hash table based implementation of the Map interface. This implementation provides all of the optional map operations, and permits null values and the null key.");

        //2
        System.out.println(checkStringsAnagram("gallery", "allergy"));
    }

    /*1. Write a Java method to count the number of words in a string
    Example: "as soon as possible" should return "as: 2, soon: 1, possible: 1"*/
    public static void getWordsWithCount(String sentence) {
        Map<String, Integer> wordsWithCount = new LinkedHashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(sentence, " ");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase().replace(",", "").replace(".", "");

            wordsWithCount.merge(word, 1, Integer::sum);

            /*if (wordsWithCount.containsKey(word)) {
                int amount = wordsWithCount.get(word) + 1;
                wordsWithCount.put(word, amount);
                continue;
            }
            wordsWithCount.put(word, 1);*/
        }
        System.out.println(wordsWithCount);
    }

    /*2. Write a Java method to check if two strings are anagrams of each other or not*/
    public static boolean checkStringsAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> strChars = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char str1Char = str1.charAt(i);
            char str2Char = str2.charAt(i);

            strChars.merge(str1Char, 1, Integer ::sum);
            strChars.merge(str2Char, -1, Integer ::sum);
        }

        return strChars.values().stream().allMatch(v -> v == 0);
    }


       /* for (int i = 0; i < str1.length(); i++) {
            char currChar = str1.charAt(i);

            if (str1Chars.containsKey(currChar)) {
                int amount = str1Chars.get(currChar) + 1;
                str1Chars.put(currChar, amount);
                continue;
            }
            str1Chars.put(currChar, 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            char currChar = str2.charAt(i);

            if (str1Chars.containsKey(currChar)) {
                int amount = str1Chars.get(currChar) - 1;
                str1Chars.put(currChar, amount);
            } else {
                return false;
            }
        }

        for (var entry : str1Chars.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }*/
}
