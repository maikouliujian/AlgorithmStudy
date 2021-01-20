package com.javastudy.concurrents;

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new S());
        t.run();  //本质调用的是S的run方法
    }
}

class S implements Runnable{

    @Override
    public void run() {

    }
}
