package Homework2023_01_25;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        task7();
    }

    public static void task1() {
        //Ќапишите код, который создает Stream из массива чисел,
        // фильтрует его по четным числам и выводит результат в консоль.
        int[] arr = {11,22,32,41,25,6,54,47,3,8};

        Arrays.stream(arr).filter(x -> x % 2 == 0).forEach(x -> System.out.printf("%d ", x));
    }

    public static void task2() {
        //Ќапишите код, который создает Stream из списка строк,
        // отсортировывает его по длине строк и выводит результат в консоль.
        List<String> list = List.of("a","aa","world", "bbb", "c", "hello");

        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(s -> System.out.printf("%s - %d; ", s, s.length()));
    }

    public static void task3() {
        //Ќапишите код, который создает Stream из диапазона чисел,
        // отображает каждое число к его квадрату и выводит результат в консоль.
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        Arrays.stream(arr).map(x -> x * x).forEach(x -> System.out.printf("%d ", x));
    }

    public static void task4() {
        //Ќапишите код, который создает Stream из списка объектов,
        // объедин€ет их в одну строку и выводит результат на консоль.
        List<Object> list = List.of("hello", 2, "world", 43);

        System.out.println(list.stream().map(Object::toString).reduce((s1, s2) -> String.join(" ", s1, s2)).get());
    }

    public static void task5() {
        //Ќапишите код, который создает Stream из списка чисел,
        // использу€ метод reduce() находит наибольшее число в списке.
        List<Integer> list = List.of(11,22,32,41,25,6,54,47,3,8);

        System.out.println(list.stream().reduce(Math::max).get());
    }

    public static void task6() {
        //Ќапишите код, который создает Stream из Map,
        // использу€ метод filter() и метод forEach() выводит ключ-значение только тех элементов,
        // значение которых больше заданного.
        Map<String, Integer> map = Map.of("a", 3, "b", 5, "c", 7, "d", 1, "e", 9);

        map.entrySet().stream()
                .filter(entrySet -> entrySet.getValue() > 4)
                .forEach(entrySet -> System.out.println(entrySet.getKey() + " - " + entrySet.getValue()));
    }

    public static void task7() {
        //Ќапишите код, который считывает текстовый файл и использу€ Stream API,
        // подсчитывает количество слов в файле.
        StringBuilder res = new StringBuilder();

        try {
            InputStream stream = new FileInputStream("HW2023_01_25");

            Reader reader = new InputStreamReader(stream);

            int data = reader.read();
            while (data != -1) {
                res.append((char) data);
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.stream(res.toString().split("[\s\n\t\r]+")).count());
    }
}
