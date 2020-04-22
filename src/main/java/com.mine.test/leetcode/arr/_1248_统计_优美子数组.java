package com.mine.test.leetcode.arr;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2020/4/22 11:39
 **/
public class _1248_统计_优美子数组 {

    public static void main(String[] args) {
        new Solution1().numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2);
    }
    static class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
            int[] prefixCnt = new int[nums.length + 1];
            prefixCnt[0] = 1;
            // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
            // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
            int res = 0;
            int sum = 0;  //奇数和，有多少个奇数
            for (int num: nums) {
                sum += num & 1;
                System.out.println(sum);
                prefixCnt[sum]++;
                System.out.println(Arrays.toString(prefixCnt));
                if (sum >= k) {
                    //res += prefixCnt[sum - k];
                    res += prefixCnt[sum - k];
                }
            }
            System.out.println(Arrays.toString(prefixCnt));
            return res;
        }
    }



    static class Solution1 {
        public int numberOfSubarrays(int[] nums, int k) {
            int len = nums.length;
            int res = 0;
            int oddCount = 0;
            int arr[] = new int[len + 2];
            //记录第oddCount个奇数的下标
            for (int i = 0; i < len; i++) {
                if ((nums[i] & 1) == 1) {
                    arr[++oddCount] = i;//第++oddCount个奇数的下标是i
                }
            }
            arr[0] = -1;//左边界
            arr[oddCount + 1] = len;//右边界

            System.out.println(Arrays.toString(arr));

            // arr[i]是窗口左边界
            // arr[i+k-1] 是窗口右边界
            // arr[i-1]是左边的上一个奇数，在此之后到arr[i]都可选
            // arr[i+k]是右边的下一个奇数，在此之前都arr[i+k-1]都可选
            //前面可选部分长度为arr[i]-arr[i-1]
            //后面可选部分长度为arr[i+k]-arr[i+k-1]
            //总的可能数等于前后可选的组合

            for (int i = 1; i + k < oddCount + 2; i++) {
                res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
            }
            return res;
        }




        public int numberOfSubarrays1(int[] nums, int k) {
            int len = nums.length;
            int res = 0;
            int oddCount =0; //奇数个数

            int arr[] = new int[len+2];
            for (int i = 0; i < nums.length; i++) {
                //判断奇数
                if ((nums[i] & 1) == 1){
                    //记录每个奇数的下标索引
                    arr[++oddCount] = i;
                }
            }

            arr[0] = -1;//左边界
            arr[oddCount + 1] = len;//右边界
            for (int i = 1; i + k < oddCount + 2; i++) {
                res+=(arr[i]-arr[i-1]) * (arr[i + k] - arr[i + k - 1]);
            }

            return res;
        }
    }

}
