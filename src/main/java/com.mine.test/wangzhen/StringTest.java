package com.mine.test.wangzhen;

public class StringTest {

    public static void main(String[] args) {
        String source = "ajfasjlsabao";
        String pattern = "aof";
        System.out.println(BruteForce(source,pattern));

    }


    public static int BruteForce(String source,String pattern){
        int sourcelen = source.length();
        int patternlen = pattern.length();
        for (int i = 0; i < sourcelen-patternlen+1; i++) {
            for (int j = 0; j <patternlen; j++) {
                if (source.charAt(i +j) == pattern.charAt(j)){
                    if (j == patternlen-1){
                        return i;
                    }else {
                        continue;
                    }
                }else {
                    break;
                }
            }
        }
        return -1;
    }


}
