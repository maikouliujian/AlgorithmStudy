package com.mine.test.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/9/19 10:02 下午
 * @description
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _404_左叶子之和 {
    //
    //https://leetcode-cn.com/problems/sum-of-left-leaves/solution/java-recursive-solution-by-lincs-2/
    static class Solution {
        //递归的关键是想清除递归方法的作用，然后在方法中进行当前节点的实现；
        //todo 本方法的含义是返回root根节点的所有左子叶子之和
        //todo 怎么判断是左叶子节点！！！1、首先是父节点的左节点；2、是叶子节点
        public int sumOfLeftLeaves(TreeNode root) {
            //递归终止
            if (root == null) return 0;
            //是左节点，且是叶子节点
            int sum = 0;
            if (root.left !=null && root.left.left == null && root.left.right == null){
                sum+=root.left.val;
            }
            //左子树的所有左子节点之和
            int leftSum = sumOfLeftLeaves(root.left);
            int rightSum = sumOfLeftLeaves(root.right);
            return sum + leftSum + rightSum;

        }
    }
}
