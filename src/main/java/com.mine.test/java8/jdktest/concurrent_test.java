package com.mine.test.java8.jdktest;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class concurrent_test {

    public static void main(String[] args) throws IOException {
        //ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        //caseA: dead loop
////        map.computeIfAbsent("AA", key -> map.computeIfAbsent("BB", k->"bb"));
//
//        //caseB: block, but no dead loop
//        new Thread(()->map.computeIfAbsent("AA", key -> waitAndGet())).start();
//
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(3);  //delay 1 second
//            } catch (InterruptedException e) {}
//            map.computeIfAbsent("BB", key-> "bb");
//        }).start();

        Map<String, String> map = new ConcurrentHashMap<>();
        map.computeIfAbsent("AaAa",
                key -> map.
                        computeIfAbsent("BBBB", key2 -> "value"));

    }

    private static String waitAndGet(){
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
        }
        return "AAA";
    }
}
