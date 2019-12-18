package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.PrintTool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2019/8/6 10:32
 *
 *
如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。



示例 1：

输入：[1,1,1,1,1,null,1]
输出：true

示例 2：

输入：[2,2,2,5,2]
输出：false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/univalued-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q965_单值二叉树 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = f;

        PrintTool.printTop2Bottom(a);

        System.out.println("=======================");
        Solution s = new Solution();
        PrintTool.printTop2Bottom(a);
//        TreeNode treeNode = s.maxNodeRec(a);
//        System.out.println(treeNode.val);


    }



    static class Solution {
        //todo 层级遍历二叉树，对比每一个值
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) return true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode tmp = root;
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (tmp.val != poll.val) return false;
                tmp = poll;
                if (tmp.left!=null){
                    queue.add(tmp.left);
                }

                if (tmp.right!=null){
                    queue.add(tmp.right);
                }
            }

            return true;

        }
    }
}
