package com.mine.test.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

/**
 * @author lj
 * @createDate 2019/8/20 11:00
 *
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]

自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class p120 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] prices = new int[][]{{2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i = 0; i < prices.length; i++) {
            List<Integer> inner = new ArrayList<Integer>();
            for (int j = 0; j < prices[i].length; j++) {
                inner.add(prices[i][j]);
            }
            triangle.add(inner);
        }

        int i = s.minimumTotal(triangle);
        System.out.println(i);
    }

    /***
     * 解法一 #
     * TODO 将三角形看成二位数组即可！！！
     * 1、状态表达式定义：dp[i,j] 为从最底层到i、j这个点的最短路径
     * 2、dp[i,j] = min(dp[i+1,j],dp[i+1,j+1]) + triangle[i,j]
     * @return
     */
    public static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int level = triangle.size();
            //dp含义代表从最底层到i,j点的最短路径值
            int[][] dp = new int[level + 1][level + 1];
            int max = 0;
            //从最后一层开始倒推
            for (int i = level - 1; i >= 0; i--) {
                //取出每一层的列表
                List<Integer> list = triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }

            }
            max = dp[0][0];
            return max;

        }



        public int minimumTotal1(List<List<Integer>> triangle) {
            //采用dp解法，从底向上进行递推
            int level = triangle.size();
            //定义dp为从底层到i,j的最短路径和
            int[][] dp = new int[level+1][level+1];
            //从最底层开始遍历
            for (int i = level-1; i >=0 ; i--) {
                List<Integer> data = triangle.get(i);
                for (int j = 0; j < data.size(); j++) {
                    dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + data.get(j);
                }
            }
            return dp[0][0];

        }
    }
}
