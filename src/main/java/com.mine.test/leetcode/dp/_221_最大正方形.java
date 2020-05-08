package com.mine.test.leetcode.dp;

/**
 * @author lj
 * @createDate 2020/5/8 10:26
 **/
public class _221_最大正方形 {
    //todo :思路====>动态规划问题，求最大面积，只需要求正方形最大边长
    //TODO   dp[i][j] 为 以坐标i,j结尾的  最大正方形边长
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int maxSize = 0;
        //从左上角开始遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //初始化边缘
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        //状态转移方程：看i,j的左、上、左上的最大边长中取最小值！！！
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }

                    maxSize = Math.max(maxSize,dp[i][j]);
                }
            }
        }
        return maxSize*maxSize;


    }
}
