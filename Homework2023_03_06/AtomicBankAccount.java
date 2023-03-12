package Homework2023_03_06;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBankAccount {
    private final AtomicInteger sum = new AtomicInteger(0);

    public int deposit(int amount) {
        return sum.addAndGet(amount);
    }

    public int withdraw(int amount) {
        return sum.addAndGet(-amount);
    }

    public synchronized int getSum() {
        return sum.get();
    }
}
