package suanfa.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/9/16 10:39 下午
 * @description
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/di-gui-bfshe-dfsduo-chong-fang-shi-jie-jue-quan-bu/
 */
public class _226_翻转二叉树 {

    public static void main(String[] args) {

    }

    static class Solution {
        //思路：递归
        public TreeNode invertTree(TreeNode root) {
            if (root == null || (root.right == null && root.left == null)) return root;

            return helper(root);
        }

        /***
         * 翻转以root为根节点的二叉树,并返回根节点
         * @param root
         * TODO :先翻转左右子树，再翻转整树
         */
        private TreeNode helper(TreeNode root) {
             //终止条件
            if (root == null) return null;
            if (root.left == null && root.right == null) return root;
            TreeNode left = helper(root.left);

            //转换root的左右节点
            root.left = helper(root.right);
            root.right = left;

            return root;



        }


        //todo : 先换左右节点
        public TreeNode invertTree1(TreeNode root) {
            if (root == null) return null;
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            //依次转换左右子树
            invertTree(root.left);
            invertTree(root.right);
            return root;

        }
    }
}
