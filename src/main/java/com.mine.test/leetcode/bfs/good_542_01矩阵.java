package com.mine.test.leetcode.bfs;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 注意:
 *
 *     给定矩阵的元素个数不超过 10000。
 *     给定矩阵中至少有一个元素是 0。
 *     矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lj
 * @createDate 2020/4/16 15:17
 **/
public class good_542_01矩阵 {

    //todo : 思路 广度优先进行扫描遍历
    //TODO : 因为要找距离0最近，所以要先将0入队列，非0的标记为未访问的
    //TODO :所有0的遍历结束，遍历后来加入的非0的元素
    public int[][] updateMatrix(int[][] matrix) {
        //0元素入队列
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else {
                    //非0的标识为-1，记录为未访问过的节点
                    matrix[i][j] = -1;
                }
            }
        }

        //上下左右
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0],y = poll[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                //未访问过就代表离0有距离 +1
                if (newX<m && newY <n && newX >=0 && newY>=0 && matrix[newX][newY] == -1){
                    matrix[newX][newY] =matrix[x][y] +1;
                    //TODO :加入非0元素
                    queue.add(new int[]{newX,newY});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{0,0,0},new int[]{0,1,0},new int[]{1,1,1}};
        new good_542_01矩阵().updateMatrix_dp(arr);
    }


    //TODO 思路：dp===>定义dp[i][j]为dp[i][j]离最近0的距离
    //TODO dp的递推，由dp[i][j]的上、下、左、右的最小值 + 1
    public int[][] updateMatrix_dp(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int[][] dp = new int[m][n];

        //初始化一次！！！
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        //从左上角开始遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
