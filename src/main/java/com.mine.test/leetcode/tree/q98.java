package com.mine.test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q98 {
    public static void main(String[] args) {
        
        
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(3);
        c.left = a;
        c.right = b;

        System.out.println(isValidBST(c));

    }


    public static boolean isValidBST(TreeNode root) {
        /***
         * 中根序遍历为升序 ,则为二叉搜索树
         */
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrder(root,result);

        //中序遍历结束，看加入的集合是否为升序
        for (int i = 1; i < result.size() ; i++) {
            if (result.get(i - 1) > result.get(i)){
                return false;
            }
        }

        return true;


    }


    public static void inOrder(TreeNode root, List<Integer> result) {
        /***
         * 中根序遍历
         */
         if (root!=null){
             inOrder(root.left,result);
             result.add(root.val);
             inOrder(root.right,result);
         }

    }




    /***
     * 牛逼解法
     */
    class Solution {
        /***
         * last 保存的是临时的上个节点（相对于当前节点而言）
         */
        double last = -Double.MAX_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (isValidBST(root.left)) {
                if (last < root.val) {
                    last = root.val;
                    return isValidBST(root.right);
                }
            }
            return false;
        }
    }

}
