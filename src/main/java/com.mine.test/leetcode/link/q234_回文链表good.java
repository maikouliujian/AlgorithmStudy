package com.mine.test.leetcode.link;

import com.mine.test.leetcode.ListNode;
import com.mine.test.leetcode.PrintTool;

/**
 * @author lj
 * @createDate 2019/10/30 14:30
 *
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false

示例 2:

输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q234_回文链表good {

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
        ListNode c = new ListNode(6);


        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(5);


        ListNode x = new ListNode(9);
        ListNode y = new ListNode(12);
        ListNode z = new ListNode(99);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        x.next = y;
        y.next = z;

        PrintTool.print(a);
        System.out.println("");
        ListNode reverse = reverse(a);
        PrintTool.print(reverse);
        System.out.println("");


    }

    private static ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        //TODO newHead每次都是最后一个节点返回！！！
        ListNode newHead = reverse(head.next);
        System.out.println(newHead.val);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    static class Solution {
        //TODO 思路：
        // 1、找到链表的中心点【使用快慢指针】
        // 2、将原链表的一半进行反转，逐一和未反转的一半进行比较


        public boolean isPalindrome(ListNode head) {
            //空链表和单个元素链表默认为回文链表
            if (head == null || head.next == null) return true;
            //1、寻找中间节点
            ListNode fast = head;
            ListNode show = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                show = show.next;
            }
            //show 为中间节点
            //2、反转后半链表
            ListNode newHead = reverse(show);

            //3、逐一遍历对比
            while (head != null && newHead != null) {
                if (head.val != newHead.val) return false;
                head = head.next;
                newHead = newHead.next;
            }

            return true;
        }

        public ListNode reverse(ListNode head) {
            if (head.next == null) return head;
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
