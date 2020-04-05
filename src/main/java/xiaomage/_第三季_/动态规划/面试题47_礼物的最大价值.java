package xiaomage._第三季_.动态规划;

public class 面试题47_礼物的最大价值 {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]定义：从左上角走到grid[i][j]的最大价值和；
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = grid[0][0];
        //第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }


    public int maxValue1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]定义：从左上角走到grid[i][j]的最大价值和；
        int[][] dp = new int[m][n];
//        //初始化
//        dp[0][0] = grid[0][0];
//        //第一行
//        for (int i = 1; i < n; i++) {
//            dp[0][i] = dp[0][i-1] + grid[0][i];
//        }
//        //第一列
//        for (int i = 1; i < m; i++) {
//            dp[i][0] = dp[i-1][0] + grid[i][0];
//        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j == 0){
                    dp[0][0] = grid[0][0];
                    continue;
                }

                if (i == 0){
                    dp[0][j] = dp[0][j-1] +grid[0][j];
                    continue;
                }

                if (j==0){
                    dp[i][0] = dp[i-1][0] +grid[i][0];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }
}
