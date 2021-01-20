package xiaomage._第三季_.链表;

import suanfa.leetcode.ListNode;

public class good_234_回文链表 {
    //回文链表;思路：双指针，数组双指针方便，链表不行,所以需要翻转部分链表
    //1、先采用双指针找到中间节点；2、翻转后半部分链表；
    //进行对比



    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode fast = head;
        ListNode show = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            show = show.next;
        }
        //此时show节点指向的为右半边链表的头节点
        //翻转链表
        ListNode tailNode = reverseLinklist(show);
        //进行回文校验
        while (head!=null && tailNode !=null){
            if (head.val!=tailNode.val) return false;
            head = head.next;
            tailNode = tailNode.next;
        }
        return true;

    }

    private ListNode reverseLinklist(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseLinklist(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
