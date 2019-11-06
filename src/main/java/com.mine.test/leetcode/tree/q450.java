package com.mine.test.leetcode.tree;

import com.mine.test.leetcode.PrintTool;

import java.awt.image.RasterOp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/8/6 10:32
 *
 *
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。

说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

5
/ \
3   6
/ \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

5
/ \
4   6
/     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

5
/ \
2   6
\   \
4   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q450 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = f;

        PrintTool.printTop2Bottom(a);

        System.out.println("=======================");
        Solution s = new Solution();
        s.deleteNode(a,7);
        PrintTool.printTop2Bottom(a);
//        TreeNode treeNode = s.maxNodeRec(a);
//        System.out.println(treeNode.val);


    }



    static class Solution {
        /***
         * 查找树的最大节点
         * 找最右节点为最大
         */
        public TreeNode maxNode(TreeNode root){
            if (root == null) return null;
            TreeNode tmp = root;
            while (tmp.right != null){
                tmp = tmp.right;
            }

            return tmp;
        }


        /***
         * 查找树的最大节点
         * 找最右节点为最大
         */
        public TreeNode maxNodeRec(TreeNode root){
            //递归终止条件
            if (root.right == null) return root;
            return maxNodeRec(root.right);
        }

        /***
         * 删除树的最大节点
         */
        public TreeNode deleteMaxNode(TreeNode root){
            if (root == null) return null;
            TreeNode p = root;
            TreeNode cur = root.right;
            while (cur != null){
                if (cur.right == null){
                    p.right = cur.left;
                    cur.left = null;
                    break;
                }
                p = cur;
                cur = cur.right;
            }
            return cur;
        }


        /***
         * 删除树的最大节点
         * 递归
         */
        public TreeNode deleteMaxNodeRec(TreeNode root){
            if (root == null) return null;
            if (root.right == null) {
                TreeNode left = root.left;
                root.left = null;
                return left;
            }

            root.right = deleteMaxNodeRec(root.right);
            //如果没有触发删除逻辑，则返回当前节点！！！
            return root;

        }


        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (key < root.val){
                //向左子树走
                root.left = deleteNode(root.left,key);
                //保持不断链
                return root;
            }

            if (key > root.val){
                //向右子树走
                root.right = deleteNode(root.right,key);
                //保持不断链
                return root;
            }

            //处理找到删除节点的逻辑
            assert key == root.val;

            //情况1：删除节点没有左子树,返回右节点
            if (root.left == null){
                TreeNode right = root.right;
                root.right = null;
                return right;
            }

            //情况2：删除节点没有右子树,返回左节点
            if (root.right == null){
                TreeNode left = root.left;
                root.left = null;
                return left;
            }

            //情况3：删除节点存在左右子树，则找到该节点的前继节点[左子树的最大值]
            TreeNode predecessor = maxNode(root.left);
            TreeNode predecessorCopy = new TreeNode(predecessor.val);
            predecessorCopy.left = deleteMaxNode(root.left);
            predecessorCopy.right = root.right;
            root.left = null;
            root.right  = null;

            return predecessorCopy;

        }
    }
}
