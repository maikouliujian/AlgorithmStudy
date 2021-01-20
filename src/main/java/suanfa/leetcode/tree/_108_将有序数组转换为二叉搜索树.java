package suanfa.leetcode.tree;

/**
 * @author lj
 * @createDate 2020/6/2 10:16
 **/
public class _108_将有序数组转换为二叉搜索树 {

    class Solution {
        //TODO 根据中序遍历构造平衡二叉搜索树
        public TreeNode sortedArrayToBST(int[] nums) {

            return helper(nums,0,nums.length-1);

        }

        //定义该递归方法为：将left到right中的元素，转化为 平衡二叉搜索树
        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) return null;

            //先找中间节点
            int pos = (left + right)>>1;
            TreeNode root = new TreeNode(nums[pos]);

            root.left = helper(nums,left,pos-1);
            root.right  = helper(nums,pos+1,right);
            return root;
        }
    }
}
