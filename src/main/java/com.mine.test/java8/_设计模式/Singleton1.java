package com.mine.test.java8._设计模式;

/**
 * @author lj
 * @createDate 2020/5/28 16:46
 **/
public class Singleton1 {

    private static class SingletonHolder{
        private static Singleton1 singleton1 = new Singleton1();
    }
    public static Singleton1 getInstance(){
        return SingletonHolder.singleton1;
    }
}
