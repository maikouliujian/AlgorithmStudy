package suanfa.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/9/21 8:01 上午
 * @description
 *
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _538_把二叉搜索树转换为累加树 {

    class Solution {

        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;
            int cur = root.val;
            int right = root.right == null? 0:root.right.val;
            if (root.left != null){
                root.left.val = cur + right + root.left.val;
            }
            root.val = cur+right;
            convertBST(root.right);
            convertBST(root.left);

            return root;
        }


        // https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/538-ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-ji-14/

        /***
         * 中根序遍历====》逆转
         * @param root
         * @return
         */
        int sum = 0;
        public TreeNode convertBST1(TreeNode root) {
            if (root == null) return null;
            convertBST1(root.right);
            //处理逻辑
            sum+= root.val;
            root.val = sum;
            convertBST1(root.left);
            return root;
        }


    }


}
