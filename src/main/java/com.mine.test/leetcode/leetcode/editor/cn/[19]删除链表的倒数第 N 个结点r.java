package com.mine.test.leetcode.leetcode.editor.cn;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import suanfa.leetcode.ListNode;

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
class Solution19 {

    //todo 快慢指针，先让快指针走n步，然后慢指针开始走，快指针到了末尾，慢指针指向了待删除节点
    //todo fast指向最后一个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) return head;
        ListNode fast = head;
        //todo 找到待删除节点的上一个节点
        while (n > 0 && fast!= null){
            fast = fast.next;
            n--;
        }
        //todo 不够删
        if (n > 0) return head;
        //todo 考虑边界条件！！！删除头节点！！！
        if (fast == null) return head.next;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (fast.next!=null){
            head = head.next;
            fast = fast.next;
        }
        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = removeNthFromEnd1(head, 1);
        System.out.println(listNode.val);
    }



    //todo 寻找前后指针
    //todo cur指向最后一个节点的下一个节点
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (n == 0 || head == null) return head;
        ListNode cur = head;
        ListNode pre = null; //要删除待删节点的前一个节点
        //boolean enough = false; //链表是否足够删
        while (cur!=null){
            n--;
//            if (n == 0){
//                enough = true;
//            }else if (n == -1){
//                pre = head;
//            }else if (n < -1){
//                pre = pre.next;
//            }
            if (n == -1){
                pre = head;
            }else if (n < -1){
                pre = pre.next;
            }
            cur = cur.next;

        }

        if (n > 0){
            return head;
        }
        //删除头节点
        if (pre == null){
            return head.next;
        }
        pre.next = pre.next.next;
        return head;

    }




}
//leetcode submit region end(Prohibit modification and deletion)
