package xiaomage._第三季_.二叉树;

import com.mine.test.leetcode.tree.TreeNode;

public class _236_二叉树的最近公共祖先 {


    //TODO :递归
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //根节点和其他任何节点的最近公共祖先 都是根节点
//        if (root == null || p == root || q == root ) return root;
//        //在左子树中找
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        //在右子树中找
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//
//        if (left!=null &&right == null){
//            return left;
//        }
//
//        if (left==null &&right != null){
//            return right;
//        }
//
//        if (left == null && right == null){
//            return null;
//        }
//        return root;
//
//
//    }



    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //根节点和其他任何节点的最近公共祖先 都是根节点
        if (root == null || p == root || q == root ) return root;
        //在左子树中找
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        //在右子树中找
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left != null && right!=null) return root;
        return left == null?right:left;


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q ) {
            return root;
        }
        TreeNode leftCommonAncestor =  lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor =  lowestCommonAncestor(root.right, p, q);
        //在左子树中没有找到，那一定在右子树中
        if(leftCommonAncestor == null){
            return rightCommonAncestor;
        }
        //在右子树中没有找到，那一定在左子树中
        if(rightCommonAncestor == null){
            return leftCommonAncestor;
        }
        //不在左子树，也不在右子树，那说明是根节点
        return root;
    }

}
