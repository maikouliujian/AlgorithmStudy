package xiaomage._第三季_.链表;

import com.mine.test.leetcode.ListNode;

public class reverselinklist{
    public static void main(String[] args) {

    }

    public ListNode reverst(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode tail = reverst(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    //非递归反转链表
    public ListNode reverst1(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head!=null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
