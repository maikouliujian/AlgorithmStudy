package xiaomage._第三季_.动态规划;

public class _62_不同路径 {


    //
    public int uniquePaths(int m, int n) {

        //定义dp[i][j]为从左上角到[i][j]的不同路径数
        int dp [][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //边缘部分初始化
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
