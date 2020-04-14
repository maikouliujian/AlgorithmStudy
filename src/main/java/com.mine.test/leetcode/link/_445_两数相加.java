package com.mine.test.leetcode.link;

import com.mine.test.leetcode.ListNode;
import com.mine.test.leetcode.PrintTool;

import java.util.Stack;

/**
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lj
 * @createDate 2020/4/14 10:02
 **/
public class _445_两数相加 {

    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(3);


        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(4);


        a.next = b;
        b.next = c;
        c.next = d;

        e.next = f;
        f.next = g;

        ListNode listNode = addTwoNumbers(a, e);
        PrintTool.print(listNode);

    }




    //TODO 逆序处理一般使用栈！！！！！！
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //不能破坏原链表
        ListNode tmp1= l1;
        ListNode tmp2= l2;

        while (tmp1 != null){
            stack1.push(tmp1.val);
            tmp1 = tmp1.next;
        }

        while (tmp2 != null){
            stack2.push(tmp2.val);
            tmp2 = tmp2.next;
        }

        //构建新链表
        ListNode root = new ListNode(-1);
        int add = 0;
        ListNode cur = root;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            Integer p1 = stack1.isEmpty()  ? 0:stack1.pop();
            Integer p2 = stack2.isEmpty()  ? 0:stack2.pop();

            cur.next = new ListNode((p1 + p2 +add)%10);
            add = (p1 + p2 +add)/10;

            //cur不会为null
            cur = cur.next;
        }
        //TODO 最终的进位 ===>这步的逻辑可以放在循环中统一管理
        if (add > 0)   cur.next = new ListNode(add);

        //TODO 从这步开始一下的逻辑可以省略，在遍历过程中构造反向链表即可
        ListNode newroot = root.next;
        //断链
        root.next = null;
        //反转最终链表

        return reverse_link(newroot);
    }

    private static ListNode reverse_link(ListNode root) {
        if (root == null || root.next == null) return root;
        ListNode newhead = reverse_link(root.next);
        root.next.next = root;
        root.next = null;
        return newhead;

    }




    //TODO 逆序处理一般使用栈！！！！！！
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //不能破坏原链表
        ListNode tmp1= l1;
        ListNode tmp2= l2;

        while (tmp1 != null){
            stack1.push(tmp1.val);
            tmp1 = tmp1.next;
        }

        while (tmp2 != null){
            stack2.push(tmp2.val);
            tmp2 = tmp2.next;
        }

        //构建新链表,直接反序构建
        ListNode next = null;
        ListNode cur = null;
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || add > 0){
            Integer p1 = stack1.isEmpty()  ? 0:stack1.pop();
            Integer p2 = stack2.isEmpty()  ? 0:stack2.pop();

            cur = new ListNode((p1 + p2 +add)%10);
            add = (p1 + p2 +add)/10;
            //cur不会为null
            cur.next = next;
            next = cur;
        }

        return cur;
    }
}
