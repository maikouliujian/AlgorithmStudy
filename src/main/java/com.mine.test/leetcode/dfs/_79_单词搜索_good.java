package com.mine.test.leetcode.dfs;

/**
 * @author : 刘剑
 * @date : 2020/9/15 11:55 下午
 * @description
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 */
public class _79_单词搜索_good {
    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 二维数组是矩阵。采用深度优先和回溯解决
         * @param board
         * @param word
         * @return
         */
        boolean[][] marked;
        String word;
        char[][] board;
        //四个方向
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        public boolean exist(char[][] board, String word) {
            //无法确定word开始位置在board中的位置，所以需要遍历
            int m = board.length;
            if (m == 0) return false;
            int n = board[0].length;

            //记忆化
            this.marked = new boolean[m][n];
            this.word = word;
            this.board = board;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //寻找work起点在board中的位置
                    //开启一次深度遍历
                    if (dfs(i,j,0)) return true;

                }
            }
            return false;
        }


        //TOdo 递归，要想明白递归方法的含义！！！
        //从board 的i，j开始是否可以匹配word从index开始的所有元素
        private boolean dfs(int i, int j, int index) {
           //递归终止条件:到达了work最后一个元素时，就到了结束条件
            if (index == word.length()-1){
                return board[i][j] == word.charAt(index);
            }

            if (board[i][j] == word.charAt(index)){
                //找到一个元素
                marked[i][j] = true;
                //深度优先
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];

                    if (inArea(newX,newY) && !marked[newX][newY]){  //避免在一次深度遍历中重复遍历！！！
                        if (dfs(newX,newY,index+1)) return true;
                    }
                }
                //恢复状态，方便其它遍历使用
                marked[i][j] = false;

            }
            return false;
        }

        private boolean inArea(int i, int j) {
            return i >= 0 && i < board.length && j>= 0&& j< board[0].length;
        }
    }
}
