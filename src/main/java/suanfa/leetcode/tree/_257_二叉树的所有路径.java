package suanfa.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 刘剑
 * @date : 2020/9/4 8:00 上午
 * @description 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class _257_二叉树的所有路径 {


    //https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-jie-jin-shuang-bai-b/
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        Solution s = new Solution();
        List<String> strings = s.binaryTreePaths(a);
        System.out.println(strings);


    }

    static class Solution {

        /***
         * https://leetcode-cn.com/problems/binary-tree-paths/solution/257java-liang-chong-hui-su-de-fang-shi-dfs-by-ustc/
         * 1、深度优先遍利，使用栈  或者 递归
         * 2、进行回溯
         * @param root
         * @return
         */
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) return result;
            //traversal(root,  new StringBuilder(),result);
            dfs(root,  result,new StringBuilder());
            return result;
        }

        private void dfs(TreeNode root, List<String> result, StringBuilder sb) {
            //终止条件
            if (root.left == null && root.right == null) {
                //叶子节点 直接出结果
                //todo 不再改变sb
                //result.add(sb.append(root.val).toString());
                result.add(sb.toString() + root.val);
                return;
            }

            //sb.append(root.val).append("->");
            String temp = root.val + "->";
            sb.append(temp);
            if (root.left != null) {
                //往下游追溯
                dfs(root.left, result, sb);
            }

            if (root.right != null) {
                //往下游追溯
                dfs(root.right, result, sb);
            }
            ///回溯
            String str = sb.toString();
            sb.delete(str.lastIndexOf("->") - 1, str.length());


            //sb.delete(sb.length() - temp.length(), sb.length());


        }


        private void traversal(TreeNode x, StringBuilder sb, List<String> res) {
            if (x.left == null && x.right == null){
                res.add(sb.toString() + x.val);
                return;
            }

            String temp = x.val + "->";
            sb.append(temp);
            if (x.left != null)
                traversal(x.left, sb, res);
            if (x.right != null)
                traversal(x.right, sb, res);
            sb.delete(sb.length() - temp.length(), sb.length());
        }

    }

}
