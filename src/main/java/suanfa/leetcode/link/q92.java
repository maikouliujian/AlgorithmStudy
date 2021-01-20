package suanfa.leetcode.link;

import suanfa.leetcode.ListNode;
import suanfa.leetcode.PrintTool;

/**
 * @author lj
 * @createDate 2019/10/30 14:30
 *
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q92 {

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
         * TODO :没想明白
         *
         *
         * @return
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {

            // Empty list
            if (head == null) {
                return null;
            }

            // Move the two pointers until they reach the proper starting point
            // in the list.
            ListNode cur = head, prev = null;
            while (m > 1) {
                prev = cur;
                cur = cur.next;
                m--;
                n--;
            }

            // The two pointers that will fix the final connections.
            ListNode con = prev, tail = cur;

            // Iteratively reverse the nodes until n becomes 0.
            ListNode third = null;
            while (n > 0) {
                third = cur.next;
                cur.next = prev;
                prev = cur;
                cur = third;
                n--;
            }

            // Adjust the final connections as explained in the algorithm
            if (con != null) {
                con.next = prev;
            } else {
                head = prev;
            }
            tail.next = cur;
            return head;
        }
    }

}
