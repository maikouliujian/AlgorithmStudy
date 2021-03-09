package com.mine.test.leetcode.leetcode.editor.cn;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5758 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import suanfa.leetcode.ListNode;
import suanfa.leetcode.PrintTool;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int bigger = 0;
        while (l1 != null || l2!=null){
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            cur.next = new ListNode((val1 + val2 + bigger) %10);
            bigger = (val1 + val2 + bigger)/10;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //最高位的判断
        if (bigger > 0 ) cur.next = new ListNode(bigger);
        return dummy.next;
    }


    public static ListNode addTwoNumbersNew(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int bigger = 0;
        while (l1 != null || l2!=null){
            int sum = 0;
            if (l1 != null) {
                sum+= l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum+= l2.val;
                l2 = l2.next;

            }
            cur.next = new ListNode((sum + bigger) %10);
            bigger = (sum + bigger)/10;
            cur = cur.next;


        }
        //最高位的判断
        if (bigger > 0 ) cur.next = new ListNode(bigger);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1  = new ListNode(9);
        ListNode n2  = new ListNode(9);
        ListNode n3  = new ListNode(9);
        ListNode n4  = new ListNode(9);
        ListNode n5  = new ListNode(9);
        ListNode n6  = new ListNode(9);
        ListNode n7  = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode n8  = new ListNode(9);
        ListNode n9  = new ListNode(9);
        ListNode n10  = new ListNode(9);
        ListNode n11 = new ListNode(9);
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;

        ListNode listNode = addTwoNumbersNew(n1, n4);
        PrintTool.print(listNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
