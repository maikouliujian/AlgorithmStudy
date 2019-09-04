package com.mine.test.leetcode.link;

import com.mine.test.leetcode.ListNode;

import static com.mine.test.leetcode.PrintTool.print;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q160 {
    /***
     160. 相交链表
     编写一个程序，找到两个单链表相交的起始节点。
     */


    public static void main(String[] args) {
        Solution s= new Solution();
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

        ListNode result = s.getIntersectionNode(a, x);
        System.out.println(result.val);


    }


    static class Solution {
        /***
         * TODO 自己写的！！！
         * 思路：先求出两个链表的长度差n，
         * 然后让长度长的链表先遍历n,后二者一起遍历，
         * 相等节点为较交点！！！
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode tmp1 = headA,tmp2 = headB;
            int count = 0;
            while (tmp1!=null){
                count ++;
                tmp1=tmp1.next;
            }
            while (tmp2!=null){
                count --;
                tmp2=tmp2.next;
            }
            System.out.println(count);

            //由谁开始遍历呢？？？
            ListNode fast = count >= 0? headA : headB;
            ListNode show = count >= 0? headB : headA;
            count = count >= 0?count:-count;

            while (fast!=null && count-- >0){
                fast = fast.next;
            }

            while (fast!=null && show!=null){
                if (fast == show)
                    return fast;
                fast=fast.next;
                show=show.next;
            }

            return null;
        }

        /***
         * TODO 不好理解
         * http://www.cocoachina.com/articles/28328
         */

            public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
                if (headA == null || headB == null) {
                    return null;
                }
                ListNode curA = headA;
                ListNode curB = headB;
                while (curA != curB) {
                    curA = curA == null ? headB : curA.next;
                    curB = curB == null ? headA : curB.next;
                }
                return curA;
            }
    }

}
