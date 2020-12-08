package com.mine.test.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2020/12/7 3:52 下午
 * @description
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 *
 * 和
 *
 *     4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _good_652_寻找重复的子树 {

    class Solution {
        //相同的子树，涉及到树的序列化，后根序遍历
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            if (root == null) return rs;
            helper(root);
            return rs;

        }
        Map<String,Integer> map = new HashMap<>();
        //存放根节点的result；
        List<TreeNode> rs = new ArrayList<>();

        /**
         * 序列化二叉树
         * @param root
         * @return
         *
         * 定义：序列化root为根节点的二叉树，并判断是否有重复
         */
        private String helper(TreeNode root) {
            if (root == null)return "#";
            String leftstr = helper(root.left);
            String rightstr = helper(root.right);
            String rootstr = leftstr + ","+rightstr+","+root.val;
            //判断是否存在，且存在一次
            Integer value = map.getOrDefault(rootstr, 0);
            if (value == 1){
                rs.add(root);
            }
            map.put(rootstr,value+1);
            return rootstr;

        }
    }



}
