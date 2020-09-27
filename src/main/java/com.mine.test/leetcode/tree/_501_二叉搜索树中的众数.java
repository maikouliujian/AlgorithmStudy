package com.mine.test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 刘剑
 * @date : 2020/9/24 10:47 下午
 * @description
 *
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 *     结点左子树中所含结点的值小于等于当前结点的值
 *     结点右子树中所含结点的值大于等于当前结点的值
 *     左子树和右子树都是二叉搜索树
 *
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _501_二叉搜索树中的众数 {


    class Solution {
        /***
         *todo 思路1：中根序遍历结果放入数组，2、遍历数组找出出现次数最多的！
         *
         *
         * todo 思路：进行优化：在中根序遍历中找出现次数最多的值
         * @param root
         * @return
         */
        public int[] findMode(TreeNode root) {
             inorder(root);
             int result[] = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;

        }
        int curVal = -1;
        int maxVal = -1;
        int cnt = -1;
        List<Integer> list = new ArrayList<>();
        private void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);

            //处理具体逻辑
            if (root.val == curVal){
                cnt+=1;
            }else {
                curVal= root.val;
                cnt=1;
            }

            if (cnt == maxVal){
                list.add(root.val);
            }else if (cnt > maxVal){
                list.clear();
                maxVal = cnt;
                list.add(root.val);
            }


            inorder(root.right);
        }
    }
}
