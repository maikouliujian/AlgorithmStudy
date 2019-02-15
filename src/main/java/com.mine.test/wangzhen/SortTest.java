package com.mine.test.wangzhen;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortTest {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,2,1,1,2,2,4,5,1,3,5,7,1,8};
        bucketSort(arr,9);
        System.out.println(Arrays.toString(arr));


    }


    public static void bucketSort(int[] arr,int max){
        int[] bucket = new int[max];  //定义排序用到的桶,初始化为0,用桶的索引代表原数组中的值
        for (int one : arr) {
            bucket[one]++;
        }
        //j索引用来替换原数组的值
        for (int i = 0,j = 0; i <max; i++) {
            while (bucket[i]-->0){
                arr[j++] = i;
            }
        }

        bucket = null;
    }

}
