package Homework2023_03_20;

import java.util.List;
import java.util.concurrent.*;

public class CountPrimes {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        countPrimesSequentially();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        countPrimesParallel();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));
    }

    private static void countPrimesParallel() {

        ExecutorService service = Executors.newFixedThreadPool(3);

        try {
            List<Future<Integer>> futureList = service.invokeAll(List.of(new Task(2, 250_000), new Task(250_000, 400_000), new Task(400_000, 500_000)));

            int sum = futureList.stream().mapToInt(future -> {
                try {
                    return future.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).sum();

            System.out.println("Total numbers of primes: " + sum);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }

    static class Task implements Callable<Integer> {
        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;
        int count = 0;

        @Override
        public Integer call() throws InterruptedException {
            for (int i = start; i < end; i++) {
                boolean isPrime = true;

                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) count++;
            }
            return count;
        }
    }


    private static void countPrimesSequentially() {
        int count = 0;

        for (int i = 2; i < 500_000; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                count++;
        }

        System.out.println("Total numbers of primes: " + count);
    }
}
