package com.mine.test.leetcode.tree;

/**
 * @author : 刘剑
 * @date : 2020/12/6 2:22 下午
 * @description
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _116_填充每个节点的下一个右侧节点指针 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        //一个节点递归是无法满足条件的，只能加节，添加参数
        public Node connect(Node root) {
            if (root == null) return null;
            connectTwoNode(root.left,root.right);
            return root;
        }

        private void connectTwoNode(Node left, Node right) {
            if (left == null || right == null) return;
            //连接
            left.next=right;
            connectTwoNode(left.left,left.right);
            connectTwoNode(right.left,right.right);
            connectTwoNode(left.right,right.left);
        }
    }


}
