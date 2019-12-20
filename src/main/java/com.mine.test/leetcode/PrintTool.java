package com.mine.test.leetcode;

import com.mine.test.leetcode.ListNode;
import com.mine.test.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lj
 * @createDate 2019/8/2 11:50
 **/
public class PrintTool {


    public static void print(ListNode root){
        ListNode cur = root;
        while (cur!= null){
            System.out.print(cur.val + "--->");
            cur = cur.next;

        }
        System.out.println();
    }

    /***
     * 打印二叉树   ====   二叉树的层级遍历
     * @param root
     */
    public static void printTop2Bottom(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int nextLevel = 0;// 下一层数目
        int toBePrint = 1;// 本层还要打印的数目
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
                nextLevel++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextLevel++;
            }
            //打印一个数量减少一个
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                //确认下一行要打印的数目
                toBePrint = nextLevel;
                //清空
                nextLevel = 0;
            }
        }
        System.out.println("=========================");
    }

}
