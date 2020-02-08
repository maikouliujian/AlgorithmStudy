package xiaomage._第二季_.dp;


/****

 */

public class _0_1背包问题 {

    public static void main(String[] args) {

        Solution s = new Solution();

    }



    static class Solution {
        //TODO : 背包问题dp[i][j]：前i件物品可选，最大承重为j时的最大总价值；
        public int bag(int[] weights, int[] values,int maxWeight) {
           if (weights.length == 0 || maxWeight == 0) return 0;
           int[][] dp = new int[weights.length +1][maxWeight + 1];
           //初始化
            //dp[0][0] = 0;
            for (int i = 1; i <= weights.length; i++) {
                for (int j = 1; j <= maxWeight; j++) {
                    //如果第i件物品可选【虽然是可选，但是我们可以选或者不选，主要取决于选与不选的最大值
                    // 】；即weight【i】<= 此时的最大承重j;
                    if (weights[i-1] <= j){
                        dp[i][j] = Math.max(dp[i-1][j-weights[i-1]] + values[i-1],dp[i-1][j]);
                    }else {
                        //第i件物品不可选；
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[weights.length][maxWeight];
        }
    }
}
