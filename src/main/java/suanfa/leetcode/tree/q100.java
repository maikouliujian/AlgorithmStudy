package suanfa.leetcode.tree;

import suanfa.leetcode.PrintTool;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q100 {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //深度优先遍历，看每个节点值是否一样

            //递归=================================先判断边界条件
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;

            //判断对应节点的值是否相同
            if (p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
            return false;



        }
    }



}
