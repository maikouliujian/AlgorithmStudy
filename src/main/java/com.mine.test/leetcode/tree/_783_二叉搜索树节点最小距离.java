package com.mine.test.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/9/24 11:47 下午
 * @description
 *
 *
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _783_二叉搜索树节点最小距离 {


    class Solution {
        /***
         * 思路：中根序遍历，遍历一遍找出最小值
         * @param root
         * @return
         */
        public int minDiffInBST(TreeNode root) {
            inorder(root);
            return minVal;

        }

        int minVal = Integer.MAX_VALUE;
        Integer pre = null;  ///正数很大就变为负数了
        private void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            //处理逻辑
            if (pre!=null){
                minVal = Math.min(minVal,root.val - pre);
            }

            pre = root.val;
            inorder(root.right);
        }
    }
}
