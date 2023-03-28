package Homework2023_03_20;

// TODO: Строительная фирма:
//имеет 4 бригады, каждая бригада строит 1 дом;
//фирма строит поселок из 10 домов;
//затем принимает отчет от строителей о расходах и вычисляет суммарные расходы за строительство поселка;
//после чего принимается за следующий поселок из 10 домов.
//Реализовать логику с помощью ExecutorService
//Как нужно будет поменять код, если у фирмы:
//а) Строительство будет вести только одна постоянная бригада?
//б) Бригады будут создаваться по количеству стоящихся домов, а после распускаться?

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructionCompany {

    static AtomicInteger buildingCount = new AtomicInteger(1);
    static int currSettlement = 1;

    public static void main(String[] args) {
        ExecutorService company = Executors.newFixedThreadPool(4);
        //ExecutorService company = Executors.newSingleThreadExecutor(); для одной бригады;
        //ExecutorService company = Executors.newCachedThreadPool(); по клоичеству домов;

        while (true) {
            buildVillage(company);
        }
    }

    private static void buildVillage(ExecutorService service) {
        try {
            List<Future<Integer>> futures = service.invokeAll(List.of(
                    new HomeConstruction(), new HomeConstruction(), new HomeConstruction(), new HomeConstruction(), new HomeConstruction(),
                    new HomeConstruction(), new HomeConstruction(), new HomeConstruction(), new HomeConstruction(), new HomeConstruction()
            ));

            System.out.println("The construction of the village no." + currSettlement++ + " is completed, the total cost is " + getTotal(futures));
            buildingCount.set(1);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getTotal(List<Future<Integer>> futures) {
        return futures.stream().mapToInt(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum();
    }

    static class HomeConstruction implements Callable<Integer> {
        Random r = new Random();
        private int price = 10000 + r.nextInt(5000);
        Integer current = buildingCount.getAndIncrement();

        @Override
        public Integer call() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + ": starts building a house no." + current + " in village no." + currSettlement);
            Thread.sleep(2000 + r.nextInt(4000));
            System.out.println(Thread.currentThread().getName() + ": finished building house no." + current + " with price = " + price + " and send a report.");
            return price;
        }
    }
}


