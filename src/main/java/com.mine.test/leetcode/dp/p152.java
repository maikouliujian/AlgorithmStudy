package com.mine.test.leetcode.dp;



/**
 * @author lj
 * @createDate 2019/8/20 11:00
 *
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
import static java.lang.Math.min;
import static java.lang.Math.max;
public class p152 {

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        //int[] prices = new int[]{7,6,4,3,1};


    }

    /***
     * dp
     * @return
     */
    public static class Solution {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            if (length == 0) return 0;
            if (length == 1) return nums[0];

            //采用动态规划来解决
            //todo  由于nums元素有正负之分，所以需要采用二维数组
            //todo dp[i][j]含义表示包含i元素的最大值或者最小值，j= 0为最大值，j=1为最小值
            int[][] dp = new int[length +1][2];
            int result;
            dp[0][0] = dp[0][1] = result = nums[0];

            for (int i = 1; i <length; i++) {
                dp[i][0] = max(dp[i-1][0] * nums[i],max(dp[i-1][1]*nums[i],nums[i]));
                dp[i][1] = min(dp[i-1][0] * nums[i],min(dp[i-1][1]*nums[i],nums[i]));
                result = max(result,dp[i][0] );
            }

            return result;
        }

        }




}
