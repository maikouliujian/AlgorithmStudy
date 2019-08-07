package com.mine.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/8/6 10:32
 *
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q95 {

    public static void main(String[] args) {

        List<TreeNode> treeNodes = generateTrees(3);
        for (TreeNode a :treeNodes) {
            PrintTool.printTop2Bottom(a);
        }


    }



    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateBST(1, n);
    }


    private static List<TreeNode> generateBST(int left, int right) {

        List<TreeNode> res = new LinkedList<TreeNode>();
        if (left > right) {
            // 划分不到的时候,这时候填null.
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateBST(left, i - 1);
            List<TreeNode> rightTrees = generateBST(i + 1, right);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    // 注意,每个循环都要构造新的节点,不能在for 循环外面生成.
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
