package com.mine.test.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : 刘剑
 * @date : 2020/11/28 4:17 下午
 * @description
 */
//您需要在二叉树的每一行中找到最大的值。

public class _515_在每个树行中找最大值 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(9);
        n1.left = n3;
        n1.right = n2;
        n2.right = n6;
        n3.left = n4;
        n3.right = n5;
        List<Integer> list = new Solution().largestValues(n1);
        System.out.println(list);
    }


    static class Solution {

        //层级便利
        public List<Integer> largestValues(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            if (root == null)return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                //每一层遍历
                int curMax = Integer.MIN_VALUE;
                int len = queue.size(); //这一步必须取出来，不然下面add后，size发生了变化！！！
                for (int i = 0; i < len; i++) {
                    TreeNode poll = queue.poll();
                    if (poll == null) break;
                    if (poll.val > curMax)curMax = poll.val;
                    if (poll.left!=null){
                        queue.add(poll.left);
                    }

                    if (poll.right!=null){
                        queue.add(poll.right);
                    }
                }
                result.add(curMax);
            }
            return result;
        }

    }
}
