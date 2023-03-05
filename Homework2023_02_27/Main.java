package Homework2023_02_27;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        countDivBySec(11);
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start)); //5739

        start = System.currentTimeMillis();
        countDivByPar(11);
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start)); //3868
    }

    //Посчитать количество целых чисел в диапазоне от Integer.MINVALUE до Integer.MAXVALUE,
    //которые делятся на заданное целое число без остатка.
    //Решить данную задачу последовательно и параллельно в нескольких потоках.
    // Сравнить время выполнения.

    public static void countDivBySec(int divBy) {
        int count = 0;
        for (int i=Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % divBy == 0)
                count++;
        }
        System.out.println("Total divisible by " + divBy + ": " + count);
    }

    public static void countDivByPar(int divBy) {
        CounterDivBy counter1 = new CounterDivBy(Integer.MIN_VALUE, 0, divBy);
        CounterDivBy counter2 = new CounterDivBy(0, Integer.MAX_VALUE, divBy);

        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total: " + (counter1.count + counter2.count));
    }

    static class CounterDivBy implements Runnable {
        private int start;
        private int end;
        private int divBy;
        private int count = 0;

        public CounterDivBy(int start, int end, int divBy) {
            this.start = start;
            this.end = end;
            this.divBy = divBy;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                if (i % divBy == 0) {
                    count++;
                }
            }
            System.out.println("Total divisible by " + divBy + ": " + count);
        }
    }
}
