package Homework2023_03_13;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Crossbow {

    // TODO:  Доработать логику, чтобы:
    //стрельба продолжалась бесконечно;
    //количество приносимых стрел каждый раз определял бы пользователь, вводя число arrows через консоль.

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    private static int arrows = 10;

    // When the arrows end, the wait() method is called and releases.
    public void fire() {
        for (int idx = arrows; idx >= 0; idx--) {
            if (idx != 0) {
                System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
            } else {
                System.out.println("The arrows are over");
                arrows = 0;
                System.out.println("Count arrows " + arrows);

                lock.lock();
                try {
                    condition2.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                System.out.println("Carry a new quiver with arrows!!");
                idx += arrows + 1;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // reload() brings new arrows, calls notify() method, which awakens the thread
    public void reload() {
        while (true) {
            lock.lock();
            try {
                condition2.await();

                Scanner sc = new Scanner(System.in);

                System.out.println("How many arrows do you need?");
                arrows = sc.nextInt();
                System.out.println("New arrows on the way!");
                System.out.println("Count arrows = " + arrows);

                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        Crossbow crossbow = new Crossbow();

        Thread robinHood = new Thread(crossbow::fire);
        Thread servant = new Thread(crossbow::reload);

        robinHood.start();
        servant.start();
    }
}
