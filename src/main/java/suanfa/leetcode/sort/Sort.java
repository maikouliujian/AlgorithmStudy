package suanfa.leetcode.sort;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * TODO 排序
 * @author lj
 * @createDate 2019/11/14 10:23
 **/
public class Sort {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {9,1,2,5,6,3,8,10,4};
        System.out.println(Arrays.toString(arr));
        s.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        //bubblingSort(arr);
        //insertSort(arr);
        s.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        QuickSort(0,arr.length-1,arr);
//        System.out.println(Arrays.toString(arr));


    }
    //选择排序 ：先找最小的；
    public static void selectSort(int[] src){
        for (int i = 0; i < src.length-1; i++) {
            for (int j = i+1; j < src.length; j++) {
                if (src[i] < src[j])
                swap(i,j,src);
            }
        }

    }

    //冒泡排序 ：先冒最大的
    public static void bubblingSort(int[] src){
        for (int i = 0; i < src.length-1; i++) {
            for (int j = 0; j < src.length -1- i; j++) {
                if (src[j+1] > src[j])
                swap(j+1,j,src);
            }
        }

    }
    //插入排序：前提是=====>前半部分已局部有序；
    //todo 从第二个元素开始判断
    public static void insertSort(int[] src){
        for (int i = 1; i <src.length; i++) {
            //取出当前元素
            int tmp = src[i];
            int j = i;
            //之前的元素依次与当前 元素比较
            while (j > 0 && src[j-1] > tmp){
                //向后移动
                src[j] = src[j-1];
                j--;
            }
            src[j] = tmp;
        }
    }

    public static void QuickSort(int left,int right,int[] src ){
        if(left >= right){
            return;
        }else{
            int rightValue = src[right];
            int partDex = partIt(left,right,rightValue,src);
            QuickSort(left,partDex-1,src);
            QuickSort(partDex+1,right,src);
        }
    }

    private static int partIt(int left,int right,int pivot,int[] src) {
        int leftStr  = left -1;
        int rightStr = right;
        while(true){
            while(/*leftStr<right &&*/ src[++leftStr]<pivot);
            while(rightStr>0 && src[--rightStr]>pivot);
            if(leftStr>=rightStr){  //等号必须得有；相等了就没必要交换了！！！
                break;
            }else{
                swap(leftStr,rightStr,src);
            }
        }
        swap(leftStr,right,src); //和最后的一个元素互换；
        return leftStr; //（左、右）右半部份的第一个元素的位置。
    }
    private static void swap(int left,int right, int[] src) {
        int temp = src[left];
        src[left] = src[right];
        src[right]= temp;
    }


    static class Solution{


        /***
         * 快排
         * TODO 思想：从大到小；从整体到局部
         */
        public void quickSort(int[] arr,int start, int end){
            if (start >= end) return;
            int par = partition(start,end,arr);
            quickSort(arr,start,par-1);
            quickSort(arr,par+1,end);

        }
        //start 和 end都是index
        private int partition(int start, int end, int[] arr)
        {
            //比较值
            int value = arr[end];

//            int startstr = start;
//            int endstr = end -1;  为何这样就不行？
            int startstr = start-1;
            int endstr = end;
            while (true){
//                while (arr[startstr]<value && ++startstr< end);
//                while (arr[endstr]>value && --endstr>  start);
                while (startstr< end && arr[++startstr]<value);
                while (endstr>start && arr[--endstr]>value);

                if (startstr >= endstr){
                    //跳出循环
                    break;
                }else {
                    //两者都跳出循环。找到了互换元素
                    swap(startstr,endstr,arr);
                }
            }
            //移动end位置
            swap(startstr,end,arr);

            return startstr;
        }

        private void swap(int start, int end, int[] arr) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }

        /***
         * 归并
         * TODO 思想：从小到大，从局部到 整体
         */
        public void mergeSort(int[] arr, int start,int end){
            if (start >= end) return;
            //递归切分
            int middle = start + (end -start) /2;
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1,end);

            //合并两个有序数组
            merge(arr,start,middle,end);

        }

        /***
         * 合并的逻辑
         * @param arr
         * @param start
         * @param middle
         * @param end
         */
        private void merge(int[] arr, int start, int middle, int end) {
            int i = start;
            int j = middle + 1;
            int k = 0;
            //创建等长的数组
            int[] tmp = new int[end - start +1];
            //依次比较进行合并
            while (i <= middle && j <= end){
                if (arr[i] < arr[j]){
                    tmp[k++] = arr[i++];
                }else {
                    tmp[k++] = arr[j++];
                }
            }

            //合并剩余的
            while (i <= middle){
                tmp[k++] = arr[i++];
            }

            while (j <= end){
                tmp[k++] = arr[j++];
            }

            //替换原数组
            for (int l = 0; l < tmp.length; l++) {
                arr[start++] = tmp[l];
            }

        }
    }
}
