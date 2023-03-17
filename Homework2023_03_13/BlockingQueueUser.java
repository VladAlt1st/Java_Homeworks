package Homework2023_03_13;

// TODO: BlockingQueue:
//Класс Продьюсер - генерирует сообщения в очередь
//Класс Консьюмер - забирает сообщения из очереди
//Задача - реализовать класс Consumer, который будет анализировать сообщения в очереди и при входящем сообщении "exit" заканчивать работу.
//При реализации можно использовать класс MyBlockingQueue или ReentrantLockBlockingQueue в репозитории или одну из стандартных реализаций BlockingQueue из библиотеки.

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueUser {

    static class Producer implements Runnable {

        private ArrayBlockingQueue<String> queue;

        public Producer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20 && !Thread.interrupted(); i++) {
                try {
                    if (i == 14 || i == 17) {
                        queue.put("exit");
                    } else {
                        queue.put(Thread.currentThread().getName() + ": Message " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Consumer implements Runnable {

        private ArrayBlockingQueue<String> queue;

        public Consumer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            boolean isExit = false;
            while (!isExit) {
                try {
                    String message = queue.take();

                    if (message.equalsIgnoreCase("exit")) {
                        isExit = true;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " received message: " + message +
                                " Elements in queue:" + queue.size());
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
