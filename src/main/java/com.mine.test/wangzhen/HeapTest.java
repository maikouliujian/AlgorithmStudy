package com.mine.test.wangzhen;

import java.util.Arrays;

public class HeapTest {

    public static void main(String[] args) {
        int[] arr = {2,3,6,7,10,2,3,4,7,1};

        buildHeap(arr);
        //buildMinHeap(arr);
        System.out.println(Arrays.toString(arr));
        insert(arr,3);
        System.out.println(Arrays.toString(arr));

    }


    //构建最小堆，让所有的非叶子节点下沉
    public static void buildHeap(int[] arr){
        //最后一个节点的父节点
        int last_non_leaf = ((arr.length-1)-1)/2;
        //倒序下沉
        for (int i = last_non_leaf; i >=0; i--) {
            downTOminHeap(arr,i);
        }

    }

    //节点下沉方法
    private static void downTOminHeap(int[] arr, int index) {
        //数组最大索引
        int maxIndex = arr.length-1;
        //要被下沉的值
        int value = arr[index];
        int parent = index;
        int leftChild = index * 2 +1;
        while ( leftChild <= maxIndex  /*&& value> arr[leftChild]*/){
            //父节点需要与左右子节点中较小的值换
            if (leftChild+1 <= maxIndex && arr[leftChild] > arr[leftChild +1]){
                leftChild +=1;
            }
            if (value<=arr[leftChild])break;
            //先替换
            arr[parent] = arr[leftChild];
            parent = leftChild;
            leftChild = parent *2 +1;
        }
        //最终替换值
        arr[parent] = value;
    }

    private static void insert(int[] arr,int value){
        //向堆中插入元素，是插入在尾部
        int max = arr.length -1;
        int insertIndex = max + 1;
        int parent = (insertIndex -1)/2;
        while (parent >=0){
            if (arr[parent]<=value)break;
            arr[insertIndex] = arr[parent];
            insertIndex = parent;
            parent = (parent -1)/2;
        }
        arr[insertIndex] = value;
    }

















    //第一步：先写每个非叶子节点的下沉方法：
    //构建小顶堆，找子节点中最小的那个进行替换
    public static void downAdjust(int[] array,int parentIndex,int length){
        int temp = array[parentIndex];
        int leftChild = parentIndex * 2 + 1;
        //先定循环条件
        while (leftChild < length){
            //先定位到右节点，如果有右节点,并且右节点小于左节点，则定位到右节点
            if (leftChild +1 <length && array[leftChild +1] < array[leftChild]){
                leftChild ++ ;
            }
            if (temp <= array[leftChild]){
                break;
            }
            //开始交换
            array[parentIndex] = array[leftChild];
            parentIndex = leftChild;
            leftChild = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }
    //第二步：让每个非叶子节点的下沉：
    public static void buildMinHeap(int[] array){
        //从最后一个非叶子节点开始下沉
        //最后一个非叶子节点即为最后一个节点的父节点；
        int lastNoleaf = (array.length - 2)/2;
        for (int i = lastNoleaf; i >= 0; i--) {
            downAdjust(array,i,array.length);
        }
    }



    //堆排序算法的步骤：
    // 1. 把无序数组构建成二叉堆。
    //构建大顶堆，找子节点中最大的那个进行替换
    public static void downAdjustToMaxHeap(int[] array,int parentIndex,int length){
        int temp = array[parentIndex];
        int leftChild = parentIndex * 2 + 1;
        //先定循环条件
        while (leftChild < length){
            //先定位到右节点，如果有右节点,并且右节点小于左节点，则定位到右节点
            if (leftChild +1 <length && array[leftChild +1] > array[leftChild]){
                leftChild ++ ;
            }
            if (temp >= array[leftChild]){
                break;
            }
            //开始交换
            array[parentIndex] = array[leftChild];
            parentIndex = leftChild;
            leftChild = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }
     //2. 循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。
    public static void heapSort(int[] array){
        //堆序
        //1、先构建一个大顶堆
        //2、将最后一个元素依次和第一个元素进行交换，并进行堆调整；
        for (int i = (array.length - 2)/2;i >= 0 ;i--){
            downAdjustToMaxHeap(array,i,array.length);
        }
        //依次进行交换
        for (int i = array.length -1; i > 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //恢复堆序,越来越小的堆，不包括最后一个元素
            downAdjustToMaxHeap(array,0,i);
        }
    }


}
