package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.PrintTool;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class good_105_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        
        
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        a.left = b;
        a.right = c;
        c.left = d;

        PrintTool.printTop2Bottom(a);

        Solution s = new Solution();
        PrintTool.printTop2Bottom(a);


    }



    static class Solution {

        /***
         * 思路：采用递归，前根序用来找根节点，中根序用来切分左右子树
         * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/
         * @param preorder
         * @param inorder
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

        }

        private TreeNode helper(int[] preorder, int prel, int prer, int[] inorder, int inl, int inr) {
            //递归终止条件：
            if (prel > prer || inl > inr) return null;
            //找出当前根节点
            TreeNode root = new TreeNode(preorder[prel]);

            //找出根节点在中序中的位置索引
            int pos = findRoot(root, inorder, inl, inr);

            //分别去找root的 左右子树的根节点
            //求出左右子树的长度
            //TODO 根据中序求长度
            int leftLen = pos - inl;
            int rightLen = inr - pos;

            if (leftLen > 0){
                //返回左子树的根节点
                root.left = helper(preorder,prel+1,prel + leftLen,inorder,inl,pos -1);
            }

            if (rightLen > 0){
                //返回右子树的根节点
                root.right = helper(preorder,prel+ leftLen+1 ,prer,inorder,pos +1,inr);
            }


            return root;
        }

        private int findRoot(TreeNode root, int[] inorder, int inl, int inr) {
            for (int i = inl; i <= inr ; i++) {
                if (root.val == inorder[i]){
                    return i;
                }
            }
            return -1;
        }

    }

}
