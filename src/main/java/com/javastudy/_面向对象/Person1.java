package com.javastudy._面向对象;

/**
 * @author : 刘剑
 * @date : 2020/10/28 11:01 上午
 * @description
 */
public class Person1 extends Human{
    //private String name;
    public Person1(String name) {
        super(name);
        //this.name = name;

    }

    @Override
    void print() {
        System.out.println(name);
    }
}
