package Homework2023_03_15;

// TODO: Создать модель поведения с применением Exchanger:
//необходимо доставить посылки двумя грузовиками
//грузовик 1 везет: посылка A -> C и посылка A -> D
//грузовик 2 везет: посылка B -> C и посылка B -> D
// A  _ _ _ _             _ _ _ _ B
//           \          /
//             - - E - -
//   _ _ _ _ /          \ _ _ _ _
// C                              D
//
//E - точка обмена
//каждый грузовик может отвезти обе посылки, но это не оптимально
//поэтому необходимо создать пункт E для обмена конечными посылками, так чтобы
//итоговые конечные точки были одинаковые, то есть
//грузовик 1: посылка A -> C и A -> D, после обмена: A -> D и B -> D
//грузовик 2: посылка B -> C и B -> D, после обмена: B -> C и A -> C

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerHW {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A -> C");
        list1.add("A -> C");
        list1.add("A -> D");

        List<String> list2 = new ArrayList<>();
        list2.add("B -> C");
        list2.add("B -> D");
        list2.add("B -> D");

        Exchanger<String> exchanger = new Exchanger<>();

        new Truck("Truck1", list1, "D", exchanger);
        new Truck("Truck2", list2, "C", exchanger);
    }
}

class Truck extends Thread {
    private String name;
    private List<String> cargoRoutes;
    private String priorityPoint;
    private Exchanger<String> exchanger;

    public Truck(String name, List<String> cargoRoutes, String priorityPoint, Exchanger<String> exchanger) {
        this.name = name;
        this.cargoRoutes = cargoRoutes;
        this.priorityPoint = priorityPoint;
        this.exchanger = exchanger;
        this.start();
    }

    private boolean isPriority(String cargoRout) {
        return cargoRout.endsWith(priorityPoint);
    }

    private void exchange() {
        for (int i = 0; i < cargoRoutes.size(); i++) {
            String cargoRoute = cargoRoutes.get(i);
            if (!isPriority(cargoRoute)) {
                try {
                    System.out.println(name + ": this cargo is`n in priority = [" + cargoRoute + "], trying to exchange!");
                    Thread.sleep(2000);
                    String excRoute = exchanger.exchange(cargoRoute);

                    if (isPriority(excRoute)) {
                        System.out.println("Received route is in priority, add to list of cargoRoutes for" + name + " = [" + excRoute + "]!");
                        cargoRoutes.set(i, excRoute);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Current cargoRoutes for " + name + ": " + cargoRoutes);
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " on the Way.");
            Thread.sleep(2000);
            System.out.println("Meeting on the exchange point!");
            exchange();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
