package Homework2023_02_20.Task1And2;

import java.util.Arrays;

public class UnitHW1And2 {

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
