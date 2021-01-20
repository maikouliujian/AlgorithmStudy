package com.javastudy._面向对象;

/**
 * @author : 刘剑
 * @date : 2020/11/9 4:27 下午
 * @description
 */
public class Sendtest {
    public static void main(String[] args) {
        LogSenderConfig senderConfig = LogSenderConfig.builder().reporterName("aaaa").build();
//        Sender1.getInstance(senderConfig).print();
//        LogSenderConfig senderConfig1 = LogSenderConfig.builder().reporterName("bbbb").build();
//        Sender1.getInstance(senderConfig1).print();
        Sender.getInstance().setConfig(senderConfig).print();
        LogSenderConfig senderConfig1 = LogSenderConfig.builder().reporterName("bbb").build();
        Sender.getInstance().setConfig(senderConfig1).print();


    }
}
