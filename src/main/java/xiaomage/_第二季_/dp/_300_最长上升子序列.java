package xiaomage._第二季_.dp;


/****
 给定一个无序的整数数组，找到其中最长上升子序列的长度。

 示例:

 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

 说明:

 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 你算法的时间复杂度应该为 O(n2) 。

 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _300_最长上升子序列 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] coins = new int[]{2};
        int result = s.lengthOfLIS(coins);
        System.out.println(result);

    }



    static class Solution {
        //定义dp【i】为以nums【i】结尾的最长上升子序列的长度
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
           int[] dp = new int[nums.length];
           dp[0] = 1;
           int result = 0;
           for (int i = 1; i < nums.length; i++) {
               //依次和小于i的元素进行比较
               int max = 1;
               for (int j = 0; j < i; j++) {
                   if (nums[j] >= nums[i]) continue;
                   //取出小于i的dp的最大值
                   if (dp[j] > max) max = dp[j];
                   dp[i] = max + 1;
               }
               if (dp[i] > result) result=dp[i];
           }


           return result>dp[0] ? result:dp[0];

        }



        //定义dp【i】为以nums【i】结尾的最长上升子序列的长度

        /***
         * 答案
         * @param nums
         * @return
         */
        public int lengthOfLIS1(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            //初始化，只有一个元素时
            dp[0] = 1;
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                //依次和小于i的元素进行比较
                //TODO 给dp【】默认初始值为1
                dp[i] = 1;
                //int tmpMax;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) continue;
                    //取出小于i的dp的最大值
//                    if (dp[j] > tmpMax) tmpMax = dp[j];
//                    dp[i] = tmpMax + 1;
                    //dp[i]有多种情况，取最大，+1是指加上当前元素
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                if (dp[i] > max) max=dp[i];
            }

            return max;

        }
    }
}
