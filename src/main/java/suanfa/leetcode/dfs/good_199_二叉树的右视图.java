package suanfa.leetcode.dfs;

import suanfa.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2020/4/22 9:26
 **/
public class good_199_二叉树的右视图 {


    //TODO : 广度优先遍历===>层级遍历，取每一层最后一个元素
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            //获取每一层级节点数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //添加最右边节点
                if (i == size -1){
                    result.add(node.val);
                }
                //添加节点
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }

        return result;


    }

    List<Integer> result = new ArrayList<>();

    //TODO =====>  深度优先遍历
    //TODO : 思路：每一层有且仅有一个元素会进入结果数组中！！！
    public List<Integer> rightSideView_dfs(TreeNode root) {
        //if (root == null) return result;
        dfs(root,0);
        return result;


    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (result.size() == depth){
            result.add(root.val);
        }
        //先遍历右子树
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);

    }
}
