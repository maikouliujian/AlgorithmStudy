package com.mine.test.leetcode;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q2 {
    /***
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        print(a);
        System.out.println();
        print(s.reverse(a));



    }

    public static void print(ListNode root){
        ListNode cur = root;
        while (cur!= null){
            System.out.print(cur.val + "--->");
            cur = cur.next;

        }
    }


    static class Solution {
        public ListNode reverse(ListNode root){
            if (root == null) return null;
            if (root.next == null) return root;
            ListNode pre = null;
            ListNode tmp;
            ListNode cur = root;

            while (cur != null){
                    tmp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = tmp;
            }
            return pre;

        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //反转链表
            int val1 = 0;
            int val2 = 0;
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            while (cur1!= null || cur2!=null){
                val1 += cur1.val;
                cur1 = cur1.next;

                val2 += cur2.val;
                cur2 = cur2.next;
            }


            return null;
        }
    }

}
