package com.mine.test.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author lj
 * @createDate 2020/4/20 16:16
 **/
//在 LeetCode 中，「岛屿问题」是一个系列系列问题，比如：
//
//        LeetCode 463. Island Perimeter 岛屿的周长（Easy）
//        LeetCode 695. Max Area of Island 岛屿的最大面积（Medium）
//        LeetCode 827. Making A Large Island 填海造陆（Hard）


//TODO :https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
public class _200_岛屿数量 {


    //TODO ：将二维矩阵看做图，进行图遍历===dfs、bfs
    public int numIslands_dfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇见1开始遍历
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count+=1;
                }
            }
        }
        return count;


    }

    //深度优先采用递归
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        //递归终止条件
        //isInIsland();
        if (!(i>=0 &&i<m && j>=0 && j<n) || grid[i][j]!='1'){
            return;
        }
        //如果遍历过，设置为已遍历2，避免重复遍历
        grid[i][j]='2';
        //上下左右四个方向遍历
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }



    //TODO ：将二维矩阵看做图，进行图遍历===dfs、bfs
    public int numIslands_bfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇见1开始遍历
                if (grid[i][j] == '1'){
                    count+=1;
                    grid[i][j] = '2';
                    //遍历所有1联通的节点
                    //TODO i * m + j 只是为了方便用一个数存储 i 和 j
                    queue.add( i * m + j);
                    while (!queue.isEmpty()){
                        Integer poll = queue.poll();
                        int ii = poll / m;
                        int jj = poll % m;

                        //遍历上下左右
                        if (ii-1>=0  && grid[ii-1][jj] =='1'){
                            queue.add((ii-1)*m+jj);
                            //已访问
                            grid[ii-1][jj] ='2';

                        }

                        if (ii+1<m  && grid[ii+1][jj] =='1'){
                            queue.add((ii+1)*m+jj);
                            //已访问
                            grid[ii+1][jj] ='2';

                        }


                        if (jj-1>=0  && grid[ii][jj-1] =='1'){
                            queue.add(ii*m+jj-1);
                            //已访问
                            grid[ii][jj-1] = '2';

                        }


                        if (jj+1<n  && grid[ii][jj+1] == '1'){
                            queue.add(ii*m+jj+1);
                            //已访问
                            grid[ii][jj+1] = '2';

                        }


                    }
                }
            }
        }
        return count;


    }


}
