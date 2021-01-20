package suanfa.leetcode.dp;

/**
 * @author lj
 * @createDate 2020/4/24 11:14
 *
 * https://leetcode-cn.com/problems/coin-lcci/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-eddiev/
 **/
public class _面试题08_11_硬币 {


    public int waysToChange_error(int n) {
        if (n < 0) return -1;
        int dp [] = new int[n +1];
        int coins [] = new int[]{1,5,10,25};
        //定义dp[n] 为金额数为n时的硬币数
        //转移方程为dp[n] = dp[n] + dp[n-coin]

//        //TODO 在外层循环硬币就是避免重复计算！！！
//        for (int coin : coins) {
//            for (int i = coin; i <=n ; i++) {
//                dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
//            }
//        }
        dp[0] = 1;
        //TODO 这么写会重复计算！！！
        for (int i = 0; i <= n; i++) {
            for (int coin : coins) {
                if (i - coin <0 )break;
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    public int waysToChange(int n) {
        if (n < 0) return -1;
        int dp [] = new int[n +1];
        int coins [] = new int[]{25,10,5,1};
        //定义dp[n] 为金额数为n时的硬币数
        //转移方程为dp[n] = dp[n] + dp[n-coin]
        //如果出现金额为0，那么只会有1种情况
        dp[0] = 1;
//
//        这里的dp[0]的含义是：组成0的硬币种类数为1，（没有硬币也是一种情况）
//        可以用于边界判断，作为完美能被一个硬币表示的情况为1。即：

        //TODO 在外层循环硬币就是避免重复计算！！！
        for (int coin : coins) {
            for (int i = coin; i <=n ; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
