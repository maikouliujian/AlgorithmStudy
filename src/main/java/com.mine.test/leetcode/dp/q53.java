package com.mine.test.leetcode.dp;

/**
 * @author lj
 * @createDate 2019/8/1 17:35
 **/
public class q53 {
    /***
     *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

      //todo java char的范围为 -128 --127
    public static void main(String[] args) {
        Solution s = new Solution();


    }

    static class Solution {
        /***
         * 题意是求数组中子数组的最大和，这种最优问题一般第一时间想到的就是动态规划，我们可以这样想，
         * 当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，如果出现部分序列小于零的情况，
         * 那肯定就是从当前元素算起。其转移方程就是 dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);，
         * 由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，即 dp = nums[i] + (dp > 0 ? dp : 0);。
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int len = nums.length, dp = nums[0], max = dp;
            for (int i = 1; i < len; ++i) {
                dp = nums[i] + (dp > 0 ? dp : 0);
                if (dp > max) max = dp;
            }
            return max;
        }
    }

}
