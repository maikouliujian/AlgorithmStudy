package xiaomage._第三季_.二叉树;

import com.mine.test.leetcode.tree.TreeNode;
import sun.nio.cs.ext.MacHebrew;

public class good_333_最大bst子树 {

    public int largestBSTsubtree(TreeNode root){
        if (root == null) return 0;
        //判断以root为节点的树是不是bst，是就直接返回节点数
        if (isBST(root)) return getCount(root);
        int left = largestBSTsubtree(root.left);
        int right = largestBSTsubtree(root.right);

        return Math.max(left,right);

    }

    //获取二叉树的节点数
    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return 1+getCount(root.left) + getCount(root.right);
    }

    //判断以root为根节点的树是不是bst
    private boolean isBST(TreeNode root) {
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);




    }

    //如何判断一颗树是bst====>左子树是bst，且右子树也是bst，且每个根节点需要满足其值的范围
    private boolean isBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;

        return minValue < root.val && root.val<maxValue && isBST(root.left,minValue,root.val) && isBST(root.right,root.val,maxValue);
    }
}
