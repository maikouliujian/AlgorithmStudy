package com.mine.test.java8.stringtest;

public class StringTest {

    public static void main(String[] args) {

        //https://blog.csdn.net/u014333083/article/details/80354900
        String str1=new StringBuilder("58").append("ganji").toString();
        System.out.println(str1.intern() == str1);
        String str2=new StringBuilder("ja").append("va").toString();  //java最早已经被初始化过了
        System.out.println(str2.intern() == str2);

    }
}
