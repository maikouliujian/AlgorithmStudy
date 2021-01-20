package suanfa.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lj
 * @createDate 2020/6/1 11:38
 **/
public class good_95_不同的二叉搜索树2 {

    public static void main(String[] args) {
        good_95_不同的二叉搜索树2 s = new good_95_不同的二叉搜索树2();
        List<TreeNode> treeNodes = s.generateTrees(3);
        treeNodes.stream().forEach(a -> System.out.println(a.val));
    }

    //TODO 定义 generate_trees 为返回从start到end的 所有树的根节点！！！
    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            //todo 返回所有左子树的根节点
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            //TODO 返回所有右子树的根节点
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // connect left and right trees to the root i
            //TODO 进行笛卡尔积！！！
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    //TODO 当前根节点！！！
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }
}

