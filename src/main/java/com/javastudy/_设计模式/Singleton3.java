package com.javastudy._设计模式;

/**
 * @author lj
 * @createDate 2020/5/28 16:49
 **/

class Main{
    public static void main(String[] args) {
        Singleton3 instance = Singleton3.INSTANCE;
        Singleton3 instance1 = Singleton3.INSTANCE;
        System.out.println(instance==instance1);
    }
}

public enum  Singleton3 {
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }

}
