package suanfa.wangzhen;

import java.util.ArrayList;
import java.util.Arrays;

public class Wangzhen {

    public static void main(String[] args) throws Exception{
//        int[] a = {2,0,2,0,0,2,1,1,0,2,1,0,1,2,0,1,2,0,1,0,2,1,0,2,0,1,2,0,1,2,0,2,1,0};
//        hollandSort(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(sqrt(16));
        int[] arr = new int[]{4,5,6,78,1,2,3};
        System.out.println(circleBinSearch(arr,2));

    }

    //荷兰国旗问题：
    public static void hollandSort(int[] arr){
        int start = 0;
        int end  = arr.length-1;
        int current = 0;

        while (current<=end){
            if (arr[current] == 0){
                swap(arr,start,current);
                start++;
                current++;
            }else if (arr[current] == 1){
                current++;
            }else if (arr[current] == 2){
                swap(arr,end,current);
                end--;
            }
        }

    }

    //二分法求平方根
    public static double sqrt(double v) {
        double low = 0;
        double high = v;
        //double precise = 1e-7; //阈值
        double precise = 0; //阈值
        double squre;
        double middle = -1;
        while (high - low > precise) {
            middle = low + ((high - low) / 2);
            //squre = middle * middle;
            if (middle < v /middle) {
                low = middle + 1;
            } else if (middle > v /middle) {
                high = middle -1 ;
            } else {
                return middle;
            }
        }
        return middle;

    }
    public static double sqrt1(double x){
        double i = 0;
        double j = x / 2 + 1;
        while (i <= j) {
            double mid = (i + j) / 2;
            double sq = mid * mid;
            if (mid == x /mid) return mid;
            else if (mid < x /mid) i = mid + 1;
            else j = mid - 1;
        }
        return j;
    }


    public static double sqrt2(double x) throws Exception{
        if (x == 0) return 0;
        if (x < 0) throw new Exception("negative has not sqrt");
        double last = 0.0;
        double res = 1.0;
        while (last != res) {
            last = res;
            res = (res + x/res)/2;
        }
        return res;
    }

    public static int circleBinSearch(int[] arr,int target){
        int left  = 0;
        int right = arr.length-1;
        int mid = -1;
        while (left <= right){
            mid = left + ((right -left) >>2);
            if (arr[mid] == target) return mid;
            //如果左边有序
            if (arr[left] <= arr[mid]){
                if (arr[left] <= target && target <arr[mid]){
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            //如果右边有序
            }else {
                if (arr[mid] < target && target <=arr[right]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }

        }
        return -1;

    }



    private static void swap(int[] arr, int start, int current) {
        int temp  = arr[start];
        arr[start] = arr[current];
        arr[current] = temp;

    }
}
