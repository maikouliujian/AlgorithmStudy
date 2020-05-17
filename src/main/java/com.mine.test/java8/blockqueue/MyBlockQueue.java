package com.mine.test.java8.blockqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockQueue{
    private List<Integer> container = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private volatile int size;
    private volatile int capacity;


    public MyBlockQueue(int capacity) {
        this.capacity = capacity;
    }


    public void add(int element) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (size >= capacity){
                System.out.println("队列已满，释放锁，等待消费者消费数据");
                notFull.await();
            }

            container.add(element);
            size++;
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }


    public int take() throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (size ==0){
                System.out.println("阻塞队列空了，释放锁，等待生产者生产数据");
                notEmpty.await();
            }

            Integer element = container.remove(0);
            size--;
            notFull.signal();

            return element;

        } finally {
            lock.unlock();
        }
    }
}
