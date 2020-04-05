package xiaomage._第三季_.动态规划;

public class good_72_编辑距离 {


    /***
     * 思路====>dp
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        //定义dp[i][j]为word1[0,i)变为word2[0,j)的最小编辑距离；
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m+1][n+1];

        //初始化
        //dp[0][0] = 0;   [0,0)可以理解为空串；
        dp[0][0] = 0;
        //dp[0][j] = j；  dp[i][0] = i    //任何长度为i的子串变为空串都需要i步；
        //第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //第一行
        for (int i = 1; i <=n ; i++) {
            dp[0][i] = i;
        }

        //递推矩阵的转移：dp[i][j]可以从上、左、左上 三个方向转移！！！
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int top = dp[i-1][j] +1;   //减去一个字符
                int left = dp[i][j-1] +1;  //加上一个字符
                int leftTop = dp[i-1][j-1];
                if (chars1[i-1] != chars2[j-1]){
                    leftTop++;
                }
                //取三种变换中，步数最小的！！！
                dp[i][j] = Math.min(top,Math.min(left,leftTop));
            }
        }

        return dp[m][n];


    }
}
