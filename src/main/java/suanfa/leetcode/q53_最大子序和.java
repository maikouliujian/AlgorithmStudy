package suanfa.leetcode;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q53_最大子序和 {
    public static void main(String[] args) {

    }

//https://leetcode-cn.com/problems/maximum-subarray/solution/
// dong-tai-gui-hua-jie-fa-4xing-pythondai-ma-by-mcdu/

    static class Solution {
        public int maxSubArray(int[] nums) {

            //解法1：贪心===>如果和大于0，则和为当前和加上当前值，
            //如果和小于0，则从当前值开始计入和
            //[-2,1,-3,4,-1,2,1,-5,4],
//            int sum = 0;
//            int re = nums[0];
//            for (int i = 0; i < nums.length; i++) {
//                if (sum > 0){
//                    sum += nums[i];
//                }else {
//                    //不加元素，就是断开子序列
//                    sum=nums[i];
//                }
//                re = Math.max(re,sum);
//            }
//            return re;

            //dp dp问题;
            //dp[i] 子序列问题：含义：包含元素i的子序列中最大和的那个
            //https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-jie-fa-4xing-pythondai-ma-by-mcdu/
            int len = nums.length;
            int[] dp = new int[len+1];
            dp[0] = nums[0];
            int maxValue = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
                maxValue = Math.max(dp[i],maxValue);
            }
            return maxValue;


        }
    }



}
