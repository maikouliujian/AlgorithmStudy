package com.mine.test.leetcode.arr;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2019/8/6 10:32
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q189_旋转数组good {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int k = 3;
        Solution s = new Solution();
        s.rotate(arr,k);
        System.out.println(Arrays.toString(arr));

    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            //保存最后一个元素
            int last = Integer.MIN_VALUE;
            while (k-- > 0){
                last = nums[len -1];
                //移动数组
                //System.arraycopy(nums,0,nums,1,len-1);
                for (int i = len -1; i > 0; i--) {
                    nums[i] = nums[i-1];
                }
                nums[0] = last;

            }
        }

        /**
         * 双重循环
         * 时间复杂度：O(kn)
         * 空间复杂度：O(1)
         */
        public void rotate_1(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            for (int i = 0; i < k; i++) {
                int temp = nums[n - 1];
                for (int j = n - 1; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = temp;
            }
        }
    }
}







