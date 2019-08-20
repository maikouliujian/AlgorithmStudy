package com.mine.test.leetcode.dp;

/**
 * @author lj
 * @createDate 2019/8/20 11:00
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class p70 {

    public static void main(String[] args) {
        int i = climbStairs2(10);
        System.out.println(i);

    }


    public static int climbStairs(int n) {
        //记忆化
        int[] dp = new int[n + 1];
        return recursion(n,dp);
    }

    /***
     * 解法一
     * @param n
     * @param dp
     * @return
     */
    private static int recursion(int n, int[] dp) {
        //状态转移方程
        //dp[n] = dp[n-1] + dp[n-1];
        if (n <= 2) return n;
        if (dp[n] > 0){
            //如果有值，直接返回
            return dp[n];
        }else {
            //如果没值，需要先求值
            dp[n] = recursion(n-1,dp) + recursion(n-2,dp);
            return dp[n];
        }
    }


    /***
     * 解法二
     *# todo 高效
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        //记忆化
        //todo 为了保证给0，1，2赋值，不会出现索引越界！！！
        int[] dp = new int[n +3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


}
