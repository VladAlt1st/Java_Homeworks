package Homework2023_02_20.Task1And2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class UnitHW1And2 {

    public static int[] compareArr(int[] arrA, int[] arrB) {
        Arrays.sort(arrB);
        return Arrays.stream(arrA).distinct()
                .filter(x -> Arrays.binarySearch(arrB, x) > 0)
                .toArray();
    }

    public static int[] findCommonElem(int[] arr1, int[] arr2) {
        Objects.requireNonNull(arr1);
        Objects.requireNonNull(arr2);

        if (arr1.length == 0 || arr2.length == 0) {
            return new int[0];
        }

        if (arr1 == arr2) {
            return arr1;
        }

        Set<Integer> set = new LinkedHashSet<>();
        for (int value : arr1) {
            set.add(value);
        }

        Set<Integer> result = new LinkedHashSet<>();
        for (int value : arr2) {
            if (set.contains(value)) {
                result.add(value);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


        //Напишите программу на Java и тест для нее
    //для поиска общих элементов между двумя массивами целых чисел
    public int[] findDuplicates(int[] firstArr, int[] secondArr) {
        try {
            return Arrays.stream(firstArr).distinct().filter(i -> Arrays.stream(secondArr).anyMatch(j -> j == i)).toArray();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Напишите программу на Java и тест для нее для удаления повторяющихся элементов из массива
    public int[] deleteDuplicates(int[] arr) {
            arr = Arrays.stream(arr).distinct().toArray();
        return arr;
    }
}

/*
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.*;

class UnitHW1And2Test {

    private static UnitHW1And2 checker;

    @BeforeAll
    public static void init() {
        checker = new UnitHW1And2();
    }

    @Test
    void findDuplicates() {
        int[] first = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] second = {1, 0, 6, 15, 6, 4, 7, 0};
        assertArrayEquals(new int[]{1,7}, checker.findDuplicates(first,second));
        assertNull(checker.findDuplicates(null, second));
        assertNull(checker.findDuplicates(first, null));
        assertNull(checker.findDuplicates(null, null));
    }

    @Test
    void deleteDuplicates() {
        assertArrayEquals(new int[]{0,3,-2,4,2}, checker.deleteDuplicates(new int[]{0,3,-2,4,3,2}));
        assertThrows(NullPointerException.class, () -> checker.deleteDuplicates(null));
    }
}*/
