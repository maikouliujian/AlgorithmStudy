package com.javastudy._面向对象;

/**
 * @author : 刘剑
 * @date : 2020/11/9 4:22 下午
 * @description
 */
public class Sender1 {
    private static volatile Sender1 instance = null;

    private LogSenderConfig config;
    private Sender1(LogSenderConfig config){
        this.config = config;
    };
    public static Sender1 getInstance(LogSenderConfig config) {
        if (null == instance) {
            synchronized (Sender1.class) {
                if (null == instance) {
                    instance = new Sender1(config);
                }
            }
        }
        return instance;
    }
//    public void setConfig(LogSenderConfig config) {
//        this.config = config;
//    }

    public void print(){
        System.out.println(config.getReporterName());
    }


}
