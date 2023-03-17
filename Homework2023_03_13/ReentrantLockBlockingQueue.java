package Homework2023_03_13;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// TODO: Переписать класс ReentrantLockBlockingQueue так, чтобы
//очередь была на основе массива (ArrayDeque);
//размер очереди задавался через пареметр size(capacity) в конструкторе;
//при попытки положить элемент в заполненную очередь поток-продьюсер ожидал бы освобождение места.

public class ReentrantLockBlockingQueue<T> {

    private Queue<T> queue = new ArrayDeque<>();
    private int capacity;
    private Lock lock = new ReentrantLock(true);
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public ReentrantLockBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(T item) {
        lock.lock();
        try {
            if (queue.size() >= capacity) {
                condition2.await();
            }
            queue.add(item);
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            if (queue.isEmpty()){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition2.signal();
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

    public int getSize(){
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
