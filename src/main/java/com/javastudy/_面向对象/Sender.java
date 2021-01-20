package com.javastudy._面向对象;

/**
 * @author : 刘剑
 * @date : 2020/11/9 4:22 下午
 * @description
 */
public class Sender {
    private static volatile Sender instance = null;
    private Sender(){};
    private LogSenderConfig config;
    public static Sender getInstance() {
        if (null == instance) {
            synchronized (Sender.class) {
                if (null == instance) {
                    instance = new Sender();
                }
            }
        }
        return instance;
    }
    public Sender setConfig(LogSenderConfig config) {
        this.config = config;
        return this;
    }

    public void print(){
        System.out.println(config.getReporterName());
    }


}
