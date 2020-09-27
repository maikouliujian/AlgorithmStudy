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


    /***
     *
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
     * 最近公共祖先的定义： 设节点 root 为节点 p,q 的某公共祖先，若其左子节点 root.left
     * 和右子节点 root.right 都不是 p,q的公共祖先，则称 root 是 “最近的公共祖先” 。
     *
     * 根据以上定义，若 root是 p,q的 最近公共祖先 ，则只可能为以下情况之一：
     *
     *     p 和 q在 root 的子树中，且分列 root的 异侧（即分别在左、右子树中）；
     *     p=root ，且 q 在 root的左或右子树中；
     *     q=root，且 p 在 root的左或右子树中；
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @param p
     * @param q
     * @return
     */
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

    /***
     * 典型的深度优先，自低向上找
     * @param root
     * @param p
     * @param q
     * @return
     */
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
