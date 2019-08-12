package com.mine.test.leetcode;

/**
 * @author lj
 * @createDate 2019/8/2 19:14\
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q61 {

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        /*ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);*/
        a.next = b;
        b.next = c;
        /*c.next = d;
        d.next = e;*/


        PrintTool.print(rotateRight(a,4));



    }

    public static ListNode rotateRight(ListNode root,int k){
        if (root == null || root.next == null)
            return root;

        //先求出链表长度
        int count  = 1;
        ListNode tmp = root;
        while (tmp.next!=null){
            count ++;
            tmp= tmp.next;
        }
        //如果移动数和链表长度相同，则返回原链表
        k  = k % count;
        if (k == 0) return root;

        //将链表合成环形
        tmp.next = root;
        ListNode dummy = new ListNode(-1);
        dummy.next = root;
        ListNode pre = dummy;

        for (int i = 0; i < (count - k); i++) {
            pre = pre.next;
        }
        ListNode cur  = pre.next;
        pre.next = null;//断开链表
        
        return cur;
    }
}
