package zuoshen.study.exec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author : 刘剑
 * @date : 2021/2/8 4:36 下午
 * @description
 */
public class 在无序数组中求第K小的数 {
    public static void main(String[] args) {
        int [] arr = new int[]{23,100,10,56,6,2,89};
        //System.out.println(minKth1(arr,3));
        System.out.println(minKth2(arr,1));
        //find_k(3,arr,0,arr.length-1);

    }
    /***
     * 1、堆：求第k小，使用大顶堆，将数组中所有元素插入堆结构中，堆顶即为第k小的数;时间复杂度Nlog(k)
     */
    public static class CM implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            //堆降序排列
            return o2 - o1;
        }
    }
    public static int minKth1(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new CM());
        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() < k){
                maxHeap.add(arr[i]);
            }else {
                if (arr[i] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }
        return maxHeap.poll();

    }


    //从nlog(k) ==== > o（n）
    //思路：荷兰国旗问题，改写快排
    //1、随机找一个元素pivot进行切分，左边小，右边大
    //2、再寻找第k小
    public static int minKth2(int[] arr, int k) {
        return helper1(arr,0,arr.length -1,k-1);
    }

    private static int helper(int[] arr, int start, int end, int target) {
        //if (start >= end) return -1;
        //1、切分
        int position = partition(arr,start,end);
        //2、局部有序了，在进行第k-1和position的对比
        /***
         * 分三种情况
         * 1、k-1 = position 直接找到
         * 2、k-1 < position 直接在 [0,position-1]中继续找
         * 3、k-1 > position 直接在 [position+1,end]中继续找 k-1-position 大的
         */
        //int target = k-1;
        if (position == target){
            return arr[position];
        }else if ( target < position){
            return helper(arr,start,position-1,target);
        }else {
            //todo 这一步是在[position+1,end]中继续找 k-1-position 大的，绝对位置还是target
            return helper(arr,position+1,end,target);
        }
    }


    //递归变非递归
    private static int helper1(int[] arr, int start, int end, int target) {
        //2、局部有序了，在进行第k-1和position的对比
        /***
         * 分三种情况
         * 1、k-1 = position 直接找到
         * 2、k-1 < position 直接在 [0,position-1]中继续找
         * 3、k-1 > position 直接在 [position+1,end]中继续找 k-1-position 大的
         */
        while (true){
            int position = partition(arr,start,end);
            if (position == target){
                return arr[position];
            }else if ( target < position){
                end = position-1;
            }else {
                start = position +1;
            }
        }
    }

    //划分数组，返回position意义为：
    // arr[0,position] < pivot
    // pivot < arr[position,end]
    // pivot 为随机挑选
    private static int partition(int[] arr, int start, int end) {
        int startStr = start-1;
        int endStr = end;
        int pivot = arr[end];
        while (true){
            while (startStr<end&&arr[++startStr]<pivot);
            while (endStr>start&&arr[--endStr]>pivot);
            if (endStr <= startStr){
                break;
            }else {
                swap(arr,startStr,endStr);
            }
        }
        swap(arr,startStr,end);
        return startStr;
    }

    // 在区间 [left, right] 这个区间执行 partition 操作
//    private static int partition(int[] nums, int left, int right) {
//        // 在区间随机选择一个元素作为标定点
//        if (right > left) {
//            int randomIndex = left + 1 + new Random().nextInt(right - left);
//            swap(nums, left, randomIndex);
//        }
//
//        int pivot = nums[left];
//        int j = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                j++;
//                swap(nums, j, i);
//            }
//        }
//        swap(nums, left, j);
//        return j;
//    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }



    public static int partition1(int[] arr,int low,int high){
        int temp=arr[low];
        while(low<high){
            while(arr[high]>=temp&&high>low)
                --high;
            arr[low]=arr[high];
            while(arr[low]<=temp&&low<high)
                ++low;
            arr[high]=arr[low];
        }
        arr[high]=temp;
        return high;
    }
    public static void find_k(int k,int[] arr,int low,int high){
        int temp=partition1(arr,low,high);
        if(temp==k-1){
            System.out.print("第"+k+"大的数是："+arr[temp]);
        }else if(temp>k-1){
            find_k(k,arr,low,temp-1);
        }else{
            find_k(k-temp,arr,temp+1,high);
        }
    }

}
