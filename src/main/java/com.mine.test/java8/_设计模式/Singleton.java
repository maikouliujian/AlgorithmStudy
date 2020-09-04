package com.mine.test.java8._设计模式;


/**
 * @author lj
 * @createDate 2020/5/28 16:42
 **/
public class Singleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2= Singleton.getInstance();
        System.out.println(instance == instance1);
    }
    private volatile static Singleton instance;

    private Singleton(){}
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;

    }
}
