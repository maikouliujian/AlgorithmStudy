package xiaomage._第三季_.动态规划;

public class _64_最小路径和 {

    /***
     * 思路：类面试题47
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        //定义dp[i][j]为从左上角到grid[i][j]的数字和最小
        int m  = grid.length;
        int n = grid[0].length;
        int dp [][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //处理边缘部分
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }

                if (i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                    continue;
                }

                if (j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                    continue;
                }

                //处理非边缘部分

                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];


            }
        }

        return dp[m-1][n-1];

    }
}
