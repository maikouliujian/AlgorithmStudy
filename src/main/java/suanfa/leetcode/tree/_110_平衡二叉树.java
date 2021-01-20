package suanfa.leetcode.tree;

/**
 * @author lj
 * @createDate 2020/6/2 10:40
 **/
public class _110_平衡二叉树 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int left = get_height(root.left);
            int right = get_height(root.right);
            //TODO 要想平衡，左右子树首先都得是平衡的!!!
            return Math.abs(left - right) <=1  && isBalanced(root.left) && isBalanced(root.right);

        }

        //获取以root为根节点的树的高度
        private int get_height(TreeNode root) {
            if (root == null) return 0;
            int left = get_height(root.left);
            int right = get_height(root.right);
            return left > right ? left+1:right+1;
        }
    }
}
