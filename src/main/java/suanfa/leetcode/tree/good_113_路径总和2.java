package suanfa.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lj
 * @createDate 2020/6/2 13:15
 **/
public class good_113_路径总和2 {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            dfs(root,sum,result,new ArrayList<>());
            return result;
        }

        //dfs + 回溯
        private void dfs(TreeNode root, int sum,
                                        List<List<Integer>> result,List<Integer> currentPath) {
            if (root == null) return;
            currentPath.add(root.val);
            if (root.val == sum && root.left == null && root.right == null){
                //TODO 找到了路径
                result.add(new ArrayList<>(currentPath));
            }else {
                dfs(root.left,sum-root.val,result,currentPath);
                dfs(root.right,sum-root.val,result,currentPath);
            }

            //TODO 在这进行回溯
            currentPath.remove(currentPath.size()-1);
        }
    }
}
