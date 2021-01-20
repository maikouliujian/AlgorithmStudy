package suanfa.leetcode.tree;

import suanfa.leetcode.PrintTool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q101 {
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

        /***
         * 递归解法
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;

            return isMirror(root.left,root.right);



        }

        private boolean isMirror(TreeNode left,TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;

            if (left.val == right.val){
                return isMirror(left.left,right.right) && isMirror(right.left,left.right);
            }
            return false;


        }


        /***
         * 迭代解法：广度优先遍历
         */

        public boolean isSymmetricTwo(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t1 = q.poll();
                TreeNode t2 = q.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
            return true;
        }

    }



}
