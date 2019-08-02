package com.mine.test.leetcode;

/**
 * @author lj
 * @createDate 2019/8/2 11:24
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q24 {

    //todo 这个要重点经常看看，很绕！！！！！

    public static void main(String[] args) {

        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode listNode = swapPair(a);
        PrintTool.print(listNode);



    }

    public static ListNode swapPair(ListNode root){
        //按照题目去交换节点
        //用于返回head节点的指针
        ListNode result = new ListNode(0);

        result.next = root;
        //引入一个临时指针，用来交换其后面的两个元素
        ListNode cur = result;

        while (cur.next!=null && cur.next.next!=null){
            //引入一个临时节点来交换元素；
            ListNode tmp = cur.next.next;
            cur.next.next = tmp.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }

        return result.next;

    }
}
