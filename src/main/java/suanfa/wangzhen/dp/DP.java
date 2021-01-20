package suanfa.wangzhen.dp;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author lj
 * @createDate 2019/7/15 11:07
 * 动态规划求解01背包问题
 **/
public class DP {

    public static class MiniDis {
        /***
         *    1  3  5  9
         *    2  1  3  4
         *    5  2  6  7
         *    6  8  4  3
         */
        private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        private int n = 4;
        private int[][] mem = new int[4][4];

        public int minDist(int i, int j) { // 调用 minDist(n-1, n-1);
            if (i == 0 && j == 0) return matrix[0][0];
            if (mem[i][j] > 0) return mem[i][j];

            int minLeft = Integer.MAX_VALUE;
            if (j - 1 >= 0) {
                minLeft = minDist(i, j - 1);
            }
            int minUp = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                minUp = minDist(i - 1, j);
            }

            int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
            mem[i][j] = currMinDist;

            return currMinDist;
        }

    }

    public static void main(String[] args) {
        /*int[] weight = {2, 2, 4, 6, 3};
        int i = knapsack(weight, 5, 9);
        System.out.println(i + "");*/

        MiniDis dis = new MiniDis();
        int aa = dis.minDist(3,3);
        System.out.println(aa + "");
        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 ; j++) {
                int a = dis.mem[i][j];
                System.out.println(a+ "");
            }
        }*/

    }

    /***
     *
     * @param weight 每个物品的重量
     * @param n 物品个数
     * @param w  背包可承受的重量
     *  注：组成一个n * w + 1 的矩阵，存储结果状态
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] stats = new boolean[n][w + 1];
        stats[0][0] = true;
        if (weight[0] <= w) {
            stats[0][weight[0]] = true;
        }

        //动态规划转移方程
        for (int i = 1; i < n; i++) {
            //不把第i个物品放入背包中
            for (int j = 0; j <= w; j++) {
                if (stats[i - 1][j]) {
                    stats[i][j] = true;
                }
            }

            //把第i个物品放入背包中
            for (int j = 0; j <= w - weight[i]; j++) {
                if (stats[i - 1][j]) {
                    stats[i][j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            ///最后一行的最后一个为ture的值就是：可以放入的最大重量
            if (stats[n - 1][i]) return i;
        }
        return 0;
    }


}
