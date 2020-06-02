package com.mine.test.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2020/6/2 10:59
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
 **/
public class good_111_二叉树的最小深度 {

    class Solution {
        //思路层级遍历，找出有某个节点的左右节点中为空
        public int minDepth_back(TreeNode root) {
            if (root == null) return 1;
            Queue<TreeNode> queue =  new LinkedList<>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()){
                //到达每一层
                int size = queue.size();
                if (size > 0){
                    level++;
                }else {
                    return level;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp!=null){
                        if (tmp.left!=null) queue.add(tmp.left);
                        if (tmp.right!=null) queue.add(tmp.right);
                    }
                }
            }
            return level;
        }


        /***
         * 思路：
         *
         * 很多人写出的代码都不符合 1,2 这个测试用例，是因为没搞清楚题意
         *
         * 题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点
         *
         * 题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果
         *
         * 另外这道题的关键是搞清楚递归结束条件
         *
         *     叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
         *     当 root 节点左右孩子都为空时，返回 1
         *     当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
         *     当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
         *
         * 作者：reals
         * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            //1、root的左右节点都为空，返回1
            if (root.left == null && root.right == null) return 1;
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);

            //2、左右子节点有一个为空
            if (root.left == null || root.right == null){
                //因为总有一个为空！！！
                return leftDepth + rightDepth +1;
            }
            //3、两个都不为空,返回最小的
            return Math.min(leftDepth,rightDepth)+1;
        }
    }
}
