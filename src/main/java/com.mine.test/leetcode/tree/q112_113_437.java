package com.mine.test.leetcode.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
 * 
 *
 * */
public class q112_113_437 {
    public static void main(String[] args) {
        
        
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        a.left = b;
        a.right = c;
        c.left = d;
        /***
         *       3
         *     1     4
         *         2
         */

        //PrintTool.printTop2Bottom(a);

        Solution s = new Solution();
        List<List<Integer>> lists = s._pathSum_(a, 4);
        System.out.println(lists);
        //PrintTool.printTop2Bottom(a);


    }



    static class Solution {

        /***题目：
         * 给定一个二叉树，它的每个结点都存放着一个整数值。
         *  *
         *  * 找出路径和等于给定数值的路径总数。
         *  *
         *  * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
         *  *
         *  * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
         *  *
         *  * 示例：
         *  *
         *  * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
         *  *
         *  *       10
         *  *      /  \
         *  *     5   -3
         *  *    / \    \
         *  *   3   2   11
         *  *  / \   \
         *  * 3  -2   1
         *  *
         *  * 返回 3。和等于 8 的路径有:
         *  *
         *  * 1.  5 -> 3
         *  * 2.  5 -> 2 -> 1
         *  * 3.  -3 -> 11
         *  *
         *  * 来源：力扣（LeetCode）
         *  * 链接：https://leetcode-cn.com/problems/path-sum-iii
         *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * 思路：采用递归
         * TODO 437
         * TODO 总体采用前根序遍历，遍历到以每个节点为初始点开始
         * @return
         */
        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            //int res = 0;
            //打散每个节点！！！
            return dfs(root,sum) + pathSum(root.left,sum)
                    + pathSum(root.right,sum);
        }

        private int dfs(TreeNode root, int sum) {
            int res = 0;
            if (root == null) return 0;
            //编写递归终止条件
            if (sum == root.val) return ++res;
            res += dfs(root.left,sum-root.val);
            res += dfs(root.right,sum-root.val);
            return res;
        }


        /***
         * TODO 112
         * 题目：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
         *
         * 说明: 叶子节点是指没有子节点的节点。
         *
         * 示例:
         * 给定如下二叉树，以及目标和 sum = 22，
         *
         *               5
         *              / \
         *             4   8
         *            /   / \
         *           11  13  4
         *          /  \      \
         *         7    2      1
         *
         * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/path-sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * TODO 从根节点开始 进行递归
         * @param root
         * @param sum
         * @return
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            //深度优先
            return dfs_(root,sum);

        }

        private boolean dfs_(TreeNode root, int sum) {
            if (root == null) return false;
            //递归 终止条件
            //必须为叶子节点
            if (sum == root.val && root.left == null && root.right == null) return true;
            return dfs_(root.left,sum-root.val) || dfs_(root.right,sum-root.val);
        }


        /***
         * TODO 112 的迭代法
         */
        public boolean hasPathSumIter(TreeNode root, int sum) {
            if (root == null)
                return false;

            LinkedList<TreeNode> node_stack = new LinkedList();
            LinkedList<Integer> sum_stack = new LinkedList();
            node_stack.add(root);
            sum_stack.add(sum - root.val);

            TreeNode node;
            int curr_sum;
            while ( !node_stack.isEmpty() ) {
                node = node_stack.pollLast();
                curr_sum = sum_stack.pollLast();
                if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                    return true;

                if (node.right != null) {
                    node_stack.add(node.right);
                    sum_stack.add(curr_sum - node.right.val);
                }
                if (node.left != null) {
                    node_stack.add(node.left);
                    sum_stack.add(curr_sum - node.left.val);
                }
            }
            return false;


        }


        /***
         * TODO 113  回溯算法
         * 题目：
         * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
         *
         * 说明: 叶子节点是指没有子节点的节点。
         *
         * 示例:
         * 给定如下二叉树，以及目标和 sum = 22，
         *
         *               5
         *              / \
         *             4   8
         *            /   / \
         *           11  13  4
         *          /  \    / \
         *         7    2  5   1
         *
         * 返回:
         *
         * [
         *    [5,4,11,2],
         *    [5,8,4,5]
         * ]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/path-sum-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        public List<List<Integer>> _pathSum_(TreeNode root, int sum) {

            if(root==null){
                return ans;
            }
            backTracing(root,sum,new ArrayList<Integer>());
            return ans;
        }
        public void backTracing(TreeNode root, int sum,List<Integer> list){
            if(root==null){
                return ;
            }
            sum-=root.val;
            list.add(root.val);
            //到达根节点！！！
            if(sum==0&&root.left==null&&root.right==null){
                ans.add(new ArrayList<Integer>(list));
            }else {
                backTracing(root.left, sum, new ArrayList<Integer>(list));
                backTracing(root.right, sum, new ArrayList<Integer>(list));
            }
            //TODO 回溯
            list.remove(list.size()-1);

            System.out.println(list);
        }


        public List<List<Integer>> pathSum___(TreeNode root, int sum) {
            List<List<Integer>> resultList = new ArrayList<List<Integer>>();
            pathSum(resultList,new ArrayList<Integer>(),root,sum);
            return resultList;
        }
        private void pathSum(List<List<Integer>> resultList,List<Integer> currentPath,TreeNode root,int sum){
            if(root == null){
                return;
            }
            currentPath.add(root.val);
            if(root.left == null && root.right == null && root.val == sum){
                resultList.add(new ArrayList<Integer>(currentPath));
            }else{
                pathSum(resultList,currentPath,root.left,sum - root.val);
                pathSum(resultList,currentPath,root.right,sum - root.val);
            }
            //todo 回溯！！！
            currentPath.remove(currentPath.size() - 1);
        }

    }

}
