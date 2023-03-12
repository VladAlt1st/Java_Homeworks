package Homework2023_03_06;

public class AtomicHW {
    public static void main(String[] args) {
        AtomicBankAccount bankAccount = new AtomicBankAccount();

        new Thread(() -> {
            while (true) {
                System.out.println(bankAccount.deposit(10));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(bankAccount.deposit(10));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
