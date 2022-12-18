package AlgorithmHW2022_12_13;

import java.util.Arrays;

public class Runner {

    static long[] arr;

    static long count;

    public static void main(String[] args) {
         int[] testValue = {5,10,25,50};

         //testFib(testValue);
        /*Fib(5) = 8, count = 15, timeMS = 0.
        Fib(10) = 89, count = 177, timeMS = 0.
        Fib(25) = 121393, count = 242785, timeMS = 0.
        Fib(50) = 20365011074, count = 40730022147, timeMS = 42727.*/

        //testFibTab(testValue);
        /*FibTab(5) = 8, count = 4, timeMS = 0.
        FibTab(10) = 89, count = 9, timeMS = 0.
        FibTab(25) = 121393, count = 24, timeMS = 0.
        FibTab(50) = 20365011074, count = 49, timeMS = 0.*/

        arr = new long[testValue[testValue.length - 1] + 1];
        Arrays.fill(arr, 0, arr.length, -1);

        //1 testFibMemo(testValue);
        /*FibMemo(5) = 8, count = 9, timeMS = 0.
        FibMemo(10) = 89, count = 11, timeMS = 0.
        FibMemo(25) = 121393, count = 31, timeMS = 0.
        FibMemo(50) = 20365011074, count = 51, timeMS = 0.*/

        //2 testFibMemo(testValue);
        /*FibMemo(5) = 8, count = 1, timeMS = 0.
        FibMemo(10) = 89, count = 1, timeMS = 0.
        FibMemo(25) = 121393, count = 1, timeMS = 0.
        FibMemo(50) = 20365011074, count = 1, timeMS = 0.*/
    }

    public static void testFib(int[] testValue) {
        System.out.println("Fib test");
        for (int n : testValue) {
            count = 0;

            long start = System.currentTimeMillis();
            long value = fib(n);
            long end = System.currentTimeMillis();

            System.out.printf("Fib(%d) = %d, count = %d, timeMS = %d.\n", n, value, count, end - start);
        }
    }

    public static void testFibTab(int[] testValue) {
        System.out.println("FibTab test");
        for (int n : testValue) {
            count = 0;

            long start = System.currentTimeMillis();
            long value = fibTab(n);
            long end = System.currentTimeMillis();

            System.out.printf("FibTab(%d) = %d, count = %d, timeMS = %d.\n", n, value, count, end - start);
        }
    }

    public static void testFibMemo(int[] testValue) {
        System.out.println("FibMemo test");

        for (int n : testValue) {
            count = 0;

            long start = System.currentTimeMillis();
            long value = fibMemo(n);
            long end = System.currentTimeMillis();

            System.out.printf("FibMemo(%d) = %d, count = %d, timeMS = %d.\n", n, value, count, end - start);
        }
    }

    public static long fib(int n) {
        count++;
        if (n < 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static long fibTab(int n) {
        if (n < 2) {
            return 1;
        }

        long[] arr2 = new long[n + 1];
        arr2[0] = 1;
        arr2[1] = 1;

        for (int i = 2; i <= n; i++) {
            count++;
            arr2[i] = arr2[i - 1] + arr2[i - 2];
        }
        return arr2[n];
    }

    public static long fibMemo(int n) {
        count++;
        if (arr[n] != -1) {
            return arr[n];
        }

        if (n < 2) {
            return 1;
        }

        arr[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return arr[n];
    }
}
