package suanfa.leetcode.link;

import suanfa.leetcode.ListNode;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q82 {
    /***
     给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

     示例 1:

     输入: 1->2->3->3->4->4->5
     输出: 1->2->5

     示例 2:

     输入: 1->1->1->2->3
     输出: 2->3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(7);


        ListNode x = new ListNode(100);
        ListNode y = new ListNode(99);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;


        x.next = y;
        y.next = d;


    }


    static class Solution {
        /***
         * 思路：进行遍历，维护前后指针
         *
         *
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) return head;
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (head != null && head.next != null) {
                if (head.val == head.next.val) {
                    while (head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                    head = head.next;
                } else {
                    p.next = head;
                    p = p.next;
                    head = head.next;
                }
            }
            p.next = head;
            return dummyHead.next;

        }
    }

}

