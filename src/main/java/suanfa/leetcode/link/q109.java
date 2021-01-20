package suanfa.leetcode.link;

import suanfa.leetcode.ListNode;
import suanfa.leetcode.PrintTool;
import suanfa.leetcode.tree.TreeNode;

import java.util.ArrayList;

/**
 * @author lj
 * @createDate 2019/10/30 14:30
 *
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

0
/ \
-3   9
/   /
-10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q109 {

    public static void main(String[] args) {
        Solution s = new Solution();
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(3);
//        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
//        ListNode f = new ListNode(7);
//
//
//        ListNode x = new ListNode(100);
//        ListNode y = new ListNode(99);

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        PrintTool.print(a);
//        ListNode re = s.partition(a, 3);
//        System.out.println("====================");
//        PrintTool.print(re);

    }


    static class Solution {
        /***
         * 思路：
         * TODO :解法1：
         * TODO :先把链表转为列表，然后递归构造二叉树
         *
         *
         * @return
         */
        public TreeNode sortedListToBST(ListNode head) {

            //链表变 列表
            ArrayList<ListNode> lists = new ArrayList<ListNode>();
            ListNode tmp = head;
            while (tmp!=null){
                lists.add(tmp);
                tmp = tmp.next;
            }

            //递归构造二叉树

            return getTree(lists,0,lists.size()-1);

        }

        private TreeNode getTree(ArrayList<ListNode> lists, int start, int end) {
            //递归终止条件
            if (start > end) return null;
            if (start == end) return new TreeNode(lists.get(start).val);

            //否则处理逻辑
            int mid = start + (end - start) /2;

            TreeNode root = new TreeNode(lists.get(mid).val);
            root.left = getTree(lists,start,mid-1);
            root.right = getTree(lists,mid+1,end);

            return root;
        }
    }

}
