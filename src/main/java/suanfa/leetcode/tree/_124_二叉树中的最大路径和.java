package suanfa.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/12/26 4:11 下午
 * @description
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _124_二叉树中的最大路径和 {

    class Solution {
        //https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-ikaruga/

        //https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-de-zui-da-lu-jing-he-zhu-yao-li-jie-ti-/

        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if (root == null)return 0;
            oneSideMax(root);
            return result;
        }

        /***
         * 此方法为：过root节点的路径的单边最大值，提供给root的父节点使用
         * 为何是单边，因为路径不能分叉，往父节点的方向走！！！！
         * @param root
         */
        private int oneSideMax(TreeNode root) {
            if (root == null)return 0;
            int leftMax = Math.max(oneSideMax(root.left),0);
            int rightMax = Math.max(oneSideMax(root.right),0);
            //遍历过程中寻找最大值
            result  = Math.max(result,root.val+leftMax+rightMax);
            return root.val + Math.max(leftMax,rightMax);
        }
    }
}
