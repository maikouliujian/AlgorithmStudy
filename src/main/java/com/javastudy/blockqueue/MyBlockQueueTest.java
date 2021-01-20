package com.javastudy.blockqueue;

public class MyBlockQueueTest {


    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.add(i);
                    System.out.println("拉个：" + i);

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (; ; ) {
                try {
                    System.out.println("屎壳郎开始工作，消费：" + queue.take());

                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
