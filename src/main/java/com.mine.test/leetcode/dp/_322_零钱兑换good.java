package com.mine.test.leetcode.dp;


/****
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 示例 1:

 输入: coins = [1, 2, 5], amount = 11
 输出: 3
 解释: 11 = 5 + 5 + 1

 示例 2:

 输入: coins = [2], amount = 3
 输出: -1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/coin-change
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _322_零钱兑换good {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] coins = new int[]{2};
        int result = s.coinChange3(coins,3);
        System.out.println(result);

    }



    static class Solution {
        /***
         * TODO 方法1：暴力递归【自顶向下，存在重复计算问题】
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange1(int[] coins, int amount) {
            //coins = [1, 2, 5]
              return help(amount);

        }

        private int help(int amount) {
            //如果出现了负值，则取不到该值
            if (amount <=0) return Integer.MAX_VALUE;
            if (amount == 1 || amount == 2 || amount==5) return 1;
            int count1 = Math.min(help(amount-1), help(amount-2));
            int count2 = Math.min(help(amount-5),count1) +1;

            return count2;
        }


        /***
         * TODO 方法2：递归 + 记忆化搜索
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange2(int[] coins, int amount) {
            //coins = [1, 2, 5]
            if (amount <=0) return -1;
            //记忆化
            int[] dp = new int[amount+1];
            //初始化
            //if (amount == 1 || amount == 2 || amount==5) dp[amount] = 1;
            //dp[1] = dp[2] = dp[5] = 1;  //会数组越界
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] > amount) continue;
                dp[coins[i]] = 1;
            }

            return help1(amount,dp);

        }

        private int help1(int amount,int[] dp) {
            if (amount <=0) return Integer.MAX_VALUE;

            if (dp[amount] ==0){
                int count1 = Math.min(help1(amount-1,dp), help1(amount-2,dp));
                int count2 = Math.min(help1(amount-5,dp),count1) +1;
                dp[amount] = count2;
            }
            return dp[amount];

        }


        /***
         * dp问题
         * @param coins
         * @param amount
         * @return
         */
        //定义dp【i】为凑够金额i所需的最少硬币数
        public int coinChange3(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount <= 0) return -1;
            int[] dp = new int[amount+1];
            for (int i = 1; i <= amount; i++) {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i < coin || dp[i-coin] < 0) {
                        continue;
                    }
                    min = Math.min(min,dp[i-coin]);
                }
                if (min == Integer.MAX_VALUE){
                    dp[i] = -1;
                }else {
                    dp[i] = min+1;
                }

            }
            return dp[amount];

        }
    }
}
