package suanfa.leetcode.tree;

import java.util.*;

/**
 * @author lj
 * @createDate 2020/6/2 9:03
 **/
public class good_107_二叉树的层次遍历2 {

    class Solution {
        //思路：按照从顶层到底层进行遍历，然后放入队列中；
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                //到达每一层
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp == null) continue;
                    level.add(tmp.val);
                    if (tmp.left!=null){
                        queue.add(tmp.left);
                    }
                    if (tmp.right!=null){
                        queue.add(tmp.right);
                    }
                }
                result.add(level);
            }

            Collections.reverse(result);

            return result;

        }
    }
}
