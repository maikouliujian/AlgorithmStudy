package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.PrintTool;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q104 {
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
         * 递归，求左右子树的高度，然后 + 1
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {

            //1、先写递归终止条件
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return left > right ? left + 1: right + 1;

        }


        /***
         * 使用非递归
         * @param root
         * @return
         */
        public int maxDepthBfs(TreeNode root) {
            if (root == null) return 0;
            Queue<Pair<TreeNode,Integer>> queue = new LinkedList<Pair<TreeNode,Integer>>();
            queue.add(new Pair<TreeNode, Integer>(root,1));

            int height = 0;

            while (!queue.isEmpty()){
                Pair<TreeNode,Integer> pair = queue.poll();
                TreeNode tmp = pair.getKey();
                int tmpHeight = pair.getValue();
                //做 操作
                height = Math.max(height,tmpHeight);
                if (tmp.left!=null){
                    queue.add(new Pair<TreeNode, Integer>(tmp.left,height +1));
                }

                if (tmp.right!=null){
                    queue.add(new Pair<TreeNode, Integer>(tmp.right,height +1));
                }
            }

            return height;

        }


    }

}
