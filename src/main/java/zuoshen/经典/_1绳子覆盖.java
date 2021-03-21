package zuoshen.经典;

import java.util.Arrays;

/**
 * @author : 刘剑
 * @date : 2021/3/7 12:48 下午
 * @description
 *
 * 给定一个有序数组arr，从左到右依次表示X轴上从左往右点的位置
 * 给定一个正整数K，返回如果有一根长度为K的绳子，最多能盖住几个点
 * 绳子的边缘点碰到X轴上的点，也算盖住
 */
public class _1绳子覆盖 {


    //todo 思路：固定右端点a，计算出左端点，求左边数组中【小于a的数组】大于左端点的最近的点
    //todo 这样可以求出以数组中每个元素结尾覆盖的点，总体求最大值
    //todo 遍历数组一遍o(n) * 每一次二分查找log(n)->nlog(n)
    public static int maxPoint1(int[] arr, int L) {
        if (arr.length == 0 || L <= 0) return 0;
        if (arr[arr.length-1] - arr[0] <= L) return arr.length;
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int leftIndex = rightNearest(arr,cur-L,i);
            result = Math.max(result,i-leftIndex+1);
        }
        return result;
    }

    //todo 在arr中寻找大于value的最小值的索引
    private static int rightNearest(int[] arr, int value,int rightIndex) {
        int left = 0;
        int right  = rightIndex;
        int index = right;
        while (left <= right){
            //int mid = left + (right -left) /2;
            int mid = left + ((right -left) >>1);
            if (arr[mid] >= value){
                index = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return index;
    }


    /***
     * 二分查找，大于等于value的最小值
     * @param arr
     * @param value
     * @return
     */
    private static int nextGreatest(int[] arr, int value) {
        int left = 0;
        int right  = arr.length -1;
        int index = right;
        while (left <= right){
            //int mid = left + (right -left) /2;
            int mid = left + ((right -left) >>1);
            if (arr[mid] >= value){
                index = mid;
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return index;
    }



    /***
     * 二分查找，小于等于value的最大值
     * @param arr
     * @param value
     * @return
     */
    private static int nextLeast(int[] arr, int value) {
        int left = 0;
        int right  = arr.length -1;
        int index = right;
        while (left <= right){
            //int mid = left + (right -left) /2;
            int mid = left + ((right -left) >>1);
            if (arr[mid] <= value){
                index = mid;
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return index;
    }

//    public static void main(String[] args) {
//        int [] arr = {1,3,5,7,9};
//        int i = nextLeast(arr, 4);
//        System.out.println(i);
//    }

    //=============================
    //todo 思路二：滑动窗口进行滑动，缩减时间到o(n)
    public static int maxPoint2(int[] arr, int L) {
        //定义窗口
        //int left =0,right =0;
        int result = 1;
        //固定左窗口位置，滑动右窗口，直到滑不动
        for (int i = 0; i < arr.length; i++) {
            int index = i+1;
            while (index < arr.length && arr[index] - arr[i]<=L){
                index++;
            }
            result = Math.max(result,index - i);
        }
        return result;

    }

    public static int maxPoint3(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;
    }

    // for lc.sql

    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }

    }
}
