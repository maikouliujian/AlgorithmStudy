package com.mine.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * 进阶:
 *
 *     使用 O(n) 空间复杂度的解法很容易实现。
 *     你能想出一个只使用常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q99 {
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
        s.recoverTree(a);


        PrintTool.printTop2Bottom(a);


    }



    static class Solution {
        TreeNode t1, t2, pre;
        public void recoverTree(TreeNode root) {
            inorder(root);

            System.out.println(t1.val);
            System.out.println(t2.val);
            int temp = t1.val;
            t1.val = t2.val;
            t2.val = temp;
        }
        public void inorder(TreeNode root){
            if (root == null) return ;
            inorder(root.left);
            //处理当前节点的逻辑
            if (pre != null && pre.val > root.val) {
                if (t1 == null) t1 = pre;
                t2 = root;
            }
            pre = root;
            inorder(root.right);
        }


        public void inorderMine(TreeNode root){
            if (root == null)
            return;

            inorderMine(root.left);

            //处理当前节点逻辑；
            if (pre != null && pre.val > root.val){
                if (t1 == null){
                    t1 = pre;
                }
                t2 = root;
            }
            pre = root;

            inorderMine(root.right);
        }
    }



}
