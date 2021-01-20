package suanfa.leetcode.dp;

public class 面试题14_I_剪绳子 {


    //TODO 思路：动态规划问题：一条绳子可以任意长度进裁剪
    //TODO 定义dp[i]为长度为i的绳子被裁剪后的最大乘积
    //TODO 假如从j处切一刀 =====>   dp[i] = max(dp[i],(i-j)*j,j*dp[i-j]])
    //TODO 三种情况  1、不切   2、只在j处切一刀，3、先在j处切一刀后，接着切
    public int cuttingRope(int n) {
        if (n == 1||n == 2)return 1;
        if (n == 3)return 2;
        int[] dp = new int[n+1];
        //初始化  至少得裁剪一刀
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        //绳子长度
        for (int i = 4; i <=n ; i++) {
            //裁剪处长度
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];

    }


    /***
     * 方法五：找规律

     在面试时尽量按照常规思路去解，但是大神 @jyd 提出了一种非常巧妙的解法，可将时间复杂度降到 O(1)O(1)O(1)，值得我们去学习，他在 题解 中进行了详细的说明，这里只进行简单的总结。

     贪心法则：尽可能分解出多的 333，333 的个数为 a，得到余数 b 可能为 0，1，20，1，20，1，2：

     b = 0，返回 3a3^a3a；
     b = 1，我们将末尾的 3+13+13+1 分解成 2×22\times 22×2，因此返回 3a−1×43^{a-1}\times 43a−1×4；
     b = 2，返回 3a×23^a\times 23a×2；

     作者：z1m
     链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/xiang-jie-bao-li-di-gui-ji-yi-hua-ji-zhu-dong-tai-/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int cuttingRope1(int n ){
        return -1;
    }
}
