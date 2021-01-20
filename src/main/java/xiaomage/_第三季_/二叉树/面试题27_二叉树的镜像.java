package xiaomage._第三季_.二叉树;

import suanfa.leetcode.tree.TreeNode;

public class 面试题27_二叉树的镜像 {


    //思路===>反转二叉树
    //TODO 使用递归，关键是想清楚这个方法是干嘛的
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right==null))return root;
        TreeNode l = mirrorTree(root.left);
        TreeNode r = mirrorTree(root.right);
        //交换左右节点
        root.left = r;
        root.right = l;
        return root;
    }


    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null || (root.left == null && root.right==null))return root;
        //先交换左右节点
        TreeNode tmp = root.left;
        root.left  = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
