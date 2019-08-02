package com.mine.test.leetcode;

/**
 * @author lj
 * @createDate 2019/8/1 19:13
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 **/
public class q19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void print(ListNode root){
        ListNode cur = root;
        while (cur!= null){
            System.out.print(cur.val + "--->");
            cur = cur.next;

        }
    }

    public static void main(String[] args) {

        Solution s= new Solution();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode listNode = s.removeNthFromEnd(a, 2);
        print(listNode);

    }


    static class Solution {
        //todo 解题思路为：题意是让你删除链表中的倒数第 n 个数，我的解法是利用双指针，
        // 这两个指针相差 n 个元素，当后面的指针扫到链表末尾的时候，
        // 自然它前面的那个指针所指向的下一个元素就是要删除的元素，即 pre.next = pre.next.next;，
        // 但是如果一开始后面的指针指向的为空，此时代表的意思就是要删除第一个元素，即 head = head.next;。
        public ListNode removeNthFromEnd(ListNode head, int n) {

            if (head == null) return null;
            if (head.next == null) return null;
            ListNode fast = head, slow = head;
            //先让快指针跑n次
            while (n-- > 0){
                fast = fast.next;
            }

            if (fast != null){
                while (fast.next!=null){
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;

            }else {
                head = head.next;
            }

            return head;







            /*ListNode fast = head, slow = head*//*,cur = head*//*;
            int count = 0;


            while (fast.next !=null){

                fast = fast.next;
                if (count >= n){
                    slow = slow.next;
                }
                count+=1;

            }
            //循环结束时，可以进行删减节点
            if (slow.next != null){
                slow.next = slow.next.next;
            }

            return head;*/
        }

        //todo 此解法有问题，如果元素少于3个时；
    }
}
