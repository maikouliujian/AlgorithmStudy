package xiaomage._第二季_.dp;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2019/8/1 17:35
 **/
public class q53最大子序和 {
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
        int re = s.maxSubArray(new int[]{-1,-2});
        System.out.println(re);


    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) return -1;
            if (nums.length == 1) return nums[0];
            //定义dp【n】为包含第n个元素的最大和
            int[] dp = new int[nums.length +1];
            dp[1] = nums[0];
            int max = Integer.MIN_VALUE;
            for (int i = 2; i <= nums.length; i++) {
                if (dp[i-1] > 0){
                    dp[i] = dp[i-1] + nums[i-1];
                }else {
                    dp[i] = nums[i-1];
                }
                //取出最大值
                if (dp[i] > max) max = dp[i];
            }
//            System.out.println(Arrays.toString(dp));
            if (dp[1] > max) max = dp[1];

            return max;

        }


        /***
         * 答案！！！
         * @param nums
         * @return
         */
        public int maxSubArray1(int[] nums) {
            if (nums.length == 0) return -1;
            if (nums.length == 1) return nums[0];
            //定义dp【i】为以num【i】结尾的最大子序列和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i-1] > 0){
                    dp[i] = dp[i-1] + nums[i];
                }else {
                    dp[i] = nums[i];
                }
                //取出最大值
                if (dp[i] > max) max = dp[i];
            }

            return max;

        }



        /***
         * # todo 进行优化！！！！
         * @param nums
         * @return
         */
        public int maxSubArray2(int[] nums) {
            if (nums.length == 0) return -1;
            if (nums.length == 1) return nums[0];
            //定义dp【i】为以num【i】结尾的最大子序列和
            //todo 因为只需要保留上一个的值，所以可以对空间复杂度进行优化！！！
            //int[] dp = new int[nums.length];
            int dp = nums[0];
            int max = dp;
            for (int i = 1; i < nums.length; i++) {
                if (dp > 0){
                    dp = dp + nums[i];
                }else {
                    dp = nums[i];
                }
                //取出最大值
                if (dp > max) max = dp;
            }

            return max;

        }


    }

}
