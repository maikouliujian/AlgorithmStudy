package com.mine.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q102 {
    public static void main(String[] args) {
        
        
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        a.left = b;
        a.right = c;
        c.left = d;

        PrintTool.printTop2Bottom(a);

        Solution s = new Solution();


        PrintTool.printTop2Bottom(a);


    }



    static class Solution {

        /***
         * # todo 自己写的！！！！
         * 层级遍历：广度优先遍历，使用队列
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderMine(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> level = new ArrayList<Integer>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            //TODO 维护两个变量：1：本层剩余还要打印的数量；2：下一层将要打印的数量
            //要记录每一层级【当前层级】的数量

            int levelprint = 1;
            int nextLevel = 0;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                levelprint--;
                if (node.left != null) {
                    queue.add(node.left);
                    nextLevel++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLevel++;

                }
                if (levelprint == 0) {
                    //本层要打印的数量为0时，先把本层数组做记录，再为下一层创建一个数组
                    result.add(level);
                    level = new ArrayList<Integer>();
                    levelprint = nextLevel;
                    nextLevel = 0;
                }

            }

            return result;

        }


        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        public void helper(TreeNode node, int level) {
            // start the current level
            if (levels.size() == level)
                levels.add(new ArrayList<Integer>());

            // fulfil the current level
            levels.get(level).add(node.val);

            // process child nodes for the next level
            if (node.left != null)
                helper(node.left, level + 1);
            if (node.right != null)
                helper(node.right, level + 1);
        }

        //todo 好好看看！！！！！！！！！！！
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<List<Integer>>();
            if (root == null) return levels;

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> result = new ArrayList<Integer>();
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    result.add(tmp.val);
                    if (tmp.left != null) {
                        queue.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.add(tmp.right);

                    }
                }
                levels.add(result);
            }
            return levels;
        }




        public List<List<Integer>> levelOrderTwo(TreeNode root) {
            if (root == null) return levels;
            helper(root, 0);
            return levels;
        }


    }

}
