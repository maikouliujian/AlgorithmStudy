package com.mine.test.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/12/7 2:03 下午
 * @description
 */
public class _654_最大二叉树 {
    public static void main(String[] args) {
        new Solution().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }

    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null) return null;
            //根据左右index构造树
            return build(nums,0,nums.length-1);
        }

        //方法定义：将数组构造为树，返回根节点
        private TreeNode build(int[] nums, int left, int right) {
            if (left > right) return null;
            //求当前数组的最大值
            int maxIndex = -1,maxValue = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (nums[i] > maxValue){
                    maxValue = nums[i];
                    maxIndex = i;
                }
            }
            //构造树
            TreeNode root = new TreeNode(maxValue);
            root.left = build(nums,left,maxIndex-1);
            root.right = build(nums,maxIndex+1,right);
            return root;
        }
    }
}
