package com.mine.test.java8.class_test;

public class Demo {
    static {
        a = 0;
        //System.out.println(a);  只能访问定义在静态代码块前的变量！！！
    }
    static  int a = 1;
}
