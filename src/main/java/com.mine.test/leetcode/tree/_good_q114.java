package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.ListNode;
import com.mine.test.leetcode.PrintTool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lj
 * @createDate 2019/8/6 10:32
 *
 *
给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

1
/ \
2   5
/ \   \
3   4   6

将其展开为：

1
\
2
\
3
\
4
\
5
\
6

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class _good_q114 {

    public static void main(String[] args) {
        Solution s = new Solution();


    }

    static class Solution {
        public void flatten(TreeNode root) {
            if(root == null) return;
            helper(root);

        }

        //将以root为根的树，展开为链表,并返回头节点root
        private TreeNode helper(TreeNode root){
            if(root == null) return null;

            //先将右子树展开并保存在temp引用
            TreeNode temp = helper(root.right);
            //然后直接将左子树的展开结果接到root右侧
            root.right = helper(root.left);

            TreeNode cur = root.right;

            //一定要记得将左子树置空！！！
            root.left = null;

            //最后处理原root的右子树的部分
            if(cur == null){
                root.right = temp;
            }else{
                //找到当前右子树的最后一个节点，然后将最开始保存的temp接上
                while(cur.right != null){
                    cur = cur.right;
                }
                cur.right = temp;
            }
            return root;
        }


        //方法定义：将以root为根节点的树压平
        public void flatten1(TreeNode root) {
            if(root == null) return;
            //压平左树
            flatten1(root.left);
            //压平右树
            flatten1(root.right);
            //找到左右子树的引用
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            root.left = null;
            //连接right
            TreeNode p = root;
            while (p.right!=null){
                p = p.right;
            }
            p.right = right;





        }
    }
}
