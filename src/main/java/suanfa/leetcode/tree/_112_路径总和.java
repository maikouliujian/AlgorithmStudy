package suanfa.leetcode.tree;

/**
 * @author lj
 * @createDate 2020/6/2 11:40
 **/
public class _112_路径总和 {

    class Solution {
        //思路：求路径总和，采用深度优先遍历，   深度优先，要么递归，要么用栈
        public boolean hasPathSum(TreeNode root, int sum) {
            return dfs(root,sum);
        }

        private boolean dfs(TreeNode root, int sum) {
            if (root == null) return false;
            if (root.val == sum && root.left == null && root.right == null) return true;

            return dfs(root.left,sum-root.val) || dfs(root.right,sum-root.val);
        }
    }
}
