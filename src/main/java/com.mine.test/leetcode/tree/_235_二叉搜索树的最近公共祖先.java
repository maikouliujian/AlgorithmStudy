package com.mine.test.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/9/27 12:00 下午
 * @description
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _235_二叉搜索树的最近公共祖先 {


    class Solution {

        /***
         * Todo 公共祖先有三种情况：1、两节点都在左子树中；2、两节点都在右子树中，3、两节点分别在左右子树中；
         * @param root
         * @param p
         * @param q
         * @return
         */
        //#todo 类比 236
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

            return root;

        }

        /***
         * 由于二叉搜索树的特性，左小右大
         * 所以p,q的最近公共祖先一定是 p.val <= root.val <= q.val  # 但是p 、 q的大小无法确定
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) return root;
            //if (p.val <= root.val && root.val <= q.val)
            if (root.val > q.val && root.val > p.val){
                return lowestCommonAncestor(root.left,p,q);
            }else if (root.val < q.val && root.val < p.val){
                return lowestCommonAncestor(root.right,p,q);
            }else {
                return root;
            }

        }


        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            while (true) {
                if (p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;
                } else if (p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;
                } else {
                    break;
                }
            }
            return ancestor;
        }


    }
}
