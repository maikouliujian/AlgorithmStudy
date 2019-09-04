package com.mine.test.leetcode.link;

import com.mine.test.leetcode.ListNode;
import com.mine.test.leetcode.PrintTool;

import java.util.List;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q83 {
    /***
     给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

     示例 1:

     输入: 1->1->2
     输出: 1->2

     示例 2:

     输入: 1->1->2->3->3
     输出: 1->2->3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


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
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);


        a.next = b;
        b.next = c;

        ListNode listNode = s.deleteDuplicates(a);
        PrintTool.print(listNode);
    }


    static class Solution {
        /***
         * 思路：进行遍历，维护前后指针
         *
         *
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy,cur = head;
            while (cur!=null){
                if (pre.val == cur.val){
                    pre.next = cur.next;
                }else {
                    pre.next = cur;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }

}

