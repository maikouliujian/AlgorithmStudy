package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.PrintTool;

import java.util.*;

/**
 * TODO 二叉树的四种遍历 【必须熟练掌握！！！】
 * @author lj
 * @createDate 2019/8/2 19:14\
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [1,3,2]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q94_traverse_二叉树的遍历good {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        TreeNode f = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = f;

        PrintTool.printTop2Bottom(a);
        //List<Integer> integers = preTraversalRecur(a);
        List<List<Integer>> integers = levelTraversal(a);
        System.out.println(integers);

    }


    /***
     * TODO 前根序遍历 == 递归
     * @param root
     * @return
     */
    public static List<Integer> preTraversalRecur(TreeNode root){
        if (root == null) return null;
        List<Integer> result = new ArrayList<Integer>();
        preRecHelper(root,result);
        return result;
    }

    private static void preRecHelper(TreeNode root, List<Integer> result) {
        result.add(root.val);
        TreeNode left = root.left;
        if (left!=null) preRecHelper(left,result);
        TreeNode right = root.right;
        if (right!=null) preRecHelper(right,result);

    }

    /***
     * TODO 前根序遍历 == 非递归
     * @param root
     * @return
     */
    public static List<Integer> preTraversal(TreeNode root){
        if (root == null) return null;
        List<Integer> result = new ArrayList<Integer>();
        //深度优先遍历，用栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            result.add(tmp.val);

            TreeNode right = tmp.right;
            if (right!=null) stack.push(right);

            TreeNode left = tmp.left;
            if (left!=null) stack.push(left);

        }
        return result;
    }

    private static void inorderRecHelper(TreeNode root, List<Integer> result) {
        TreeNode left = root.left;
        if (left!=null) inorderRecHelper(left,result);
        result.add(root.val);
        TreeNode right = root.right;
        if (right!=null) inorderRecHelper(right,result);

    }
    /***
     * TODO 中根序遍历 == 递归
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalRecur(TreeNode root){
        if (root == null) return null;
        List<Integer> result = new ArrayList<Integer>();
        inorderRecHelper(root,result);
        return result;
    }


    /***
     * TODO 中根序遍历 == 非递归
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root){
        if (root == null) return null;
        List<Integer> result = new ArrayList<Integer>();
        //深度优先遍历，用栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p = p.left;

            }else {
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                p = tmp.right;
            }
        }
        return result;
    }



    private static void postRecHelper(TreeNode root, List<Integer> result) {
        TreeNode left = root.left;
        if (left!=null) inorderRecHelper(left,result);

        TreeNode right = root.right;
        if (right!=null) inorderRecHelper(right,result);

        result.add(root.val);

    }
    /***
     * TODO 后根序遍历 == 递归
     * @param root
     * @return
     */
    public static List<Integer> postTraversalRecur(TreeNode root){
        if (root == null) return null;
        List<Integer> result = new ArrayList<Integer>();
        inorderRecHelper(root,result);
        return result;
    }


    /***
     * TODO 后根序遍历 == 非递归
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);   //首先将根节点压栈
        while(!stack.isEmpty()) {
            TreeNode ele = stack.pop(); //首先出栈的为根节点，其后先出右子节点，后出左子节点
            if(ele.left != null)
                stack.push(ele.left);  //将左子节点压栈
            if(ele.right != null) {
                stack.push(ele.right); //将右子节点压栈
            }
            result.add(0, ele.val); //因为出栈顺序为“根右左”，所以需要每次将元素插入list开头
        }
        return result;
    }



    //TODO :层级遍历[很重要！！！]
    private static void levelRecHelper(TreeNode root, List<List<Integer>> result,int level) {
        if (root == null) return;
        //这一步很关键
        if (result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        TreeNode left = root.left;
        if (left!=null) levelRecHelper(left,result,level +1);
        TreeNode right = root.right;
        if (right!=null) levelRecHelper(right,result,level +1);
    }
    /***
     * TODO  层级遍历 == 递归  leetcode 102
     * @param root
     * @return
     */
    public static List<List<Integer>> levelTraversalRecur(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        levelRecHelper(root,result,0);
        return result;
    }


    /***
     * TODO  层级遍历 == 非递归  leetcode 102
     * @param root
     * @return
     */
    public static List<List<Integer>> levelTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //广度优先遍历，使用栈结构
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            //从这开始控制层级遍历
            int len = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                if (tmp!=null){
                    level.add(tmp.val);
                    if (tmp.left!=null) queue.add(tmp.left);
                    if (tmp.right!=null) queue.add(tmp.right);
                }
            }
            result.add(level);
        }
        return result;
    }


    //层级遍历求数的高度
    //  TODO 重点记忆！！！  可以使用递归
    public static int levelHeight(TreeNode root){
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       int height = 0;
       int levelSize = 1; //每一层级节点的个数！！！
       while (!queue.isEmpty()){
           //每次遍历，层级节点个数减1
//           int size = queue.size();
           levelSize--;
           TreeNode tmp = queue.poll();
           if (tmp!=null){
               if (tmp.left!=null) queue.add(tmp.left);
               if (tmp.right!=null) queue.add(tmp.right);
           }

           if (levelSize == 0){
               levelSize = queue.size();
               height++;
           }

       }
       return height;

    }




































    public static List<Integer> inorderTraversalNew(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true){
            if (root!=null){
                stack.add(root);
                root = root.left;
            }else {
                if (stack.empty()){
                    return result;
                }
                //从栈取数据
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }


    }
}
