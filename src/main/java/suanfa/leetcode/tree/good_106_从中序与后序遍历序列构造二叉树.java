package suanfa.leetcode.tree;

/**
 * @author lj
 * @createDate 2020/6/1 14:46
 **/
public class good_106_从中序与后序遍历序列构造二叉树 {


    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
        }


        private TreeNode helper(int[] postorder, int posl, int posr, int[] inorder, int inl, int inr) {
            //递归终止条件
            if (posl > posr || inl > inr || posr < 0)
            return null;

            //找到当前根节点
            TreeNode root = new TreeNode(postorder[posr]);
            //post是在中序中的位置！！！
            int post = findRoot(root, inorder, inl, inr);
            int leftLen = post - inl;
            int rightLen = inr - post;

            if (leftLen > 0){
                root.left = helper(postorder,posl,posl+leftLen-1,inorder,inl,post-1);
            }
            if (rightLen > 0){
                root.right  = helper(postorder,posl+leftLen,posr-1,inorder,post+1,inr);
            }
            return root;

        }

        private int findRoot(TreeNode root, int[] inorder, int inl, int inr) {
            for (int i = inl; i <= inr; i++) {
                if (root.val == inorder[i]){
                    return i;
                }
            }
            return -1;
        }
    }


}
