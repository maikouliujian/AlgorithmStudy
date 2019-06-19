package com.mine.test.face40jiang.forjava;

import java.util.List;

public class study {

    public static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode head = swapNodeinPais(a);
        print(head);

    }




    /***
     * 交换相邻节点
     */
    public static ListNode swapNodeinPais(ListNode head){
        if (head == null || head.next == null) return head;

        //需要引入一个前驱节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dummy = pre;

        while (pre.next!= null && pre.next.next!=null){
            ListNode a = pre.next;
            ListNode b = a.next;   //引用操作的是其具体指向的对象

            a.next = b.next;
            b.next = a;
            pre.next  = b;

            //移动
            pre = pre.next.next;
            //pre = a;
        }

        return dummy.next;

    }

    public static void  print(ListNode head){
        while (head!=null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }




}
