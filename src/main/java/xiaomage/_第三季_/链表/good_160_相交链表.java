package xiaomage._第三季_.链表;

import suanfa.leetcode.ListNode;

public class good_160_相交链表 {


    /***
     * 解法1：先让长链表遍历一定长度，再和短链表一起遍历
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null )return null;
        //两链表长度差
        int diff = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1!=null){
            cur1 = cur1.next;
            diff++;
        }
        while (cur2!=null){
            cur2 = cur2.next;
            diff--;
        }
        //如果diff>0，说明headA长，反之，headB长

        ListNode longNode = diff >= 0 ? headA:headB;
        ListNode shortNode = diff < 0 ? headA:headB;
        int cnt = Math.abs(diff);
        while (cnt-->0){
            longNode = longNode.next;
        }
        while (longNode!=null && shortNode!=null){
            if (longNode == shortNode) return longNode;
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return null;


    }



    /***
     * 解法2：链表的拼接，让两个链表长度相等
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null )return null;
        //因为要拼接链表，所以头节点不能破坏；
        ListNode cur1 = headA,cur2 = headB;
        //最终的结果有两种：1、找到相交点；2、null == null退出
        while (cur1!=cur2){
            cur1 = cur1 == null ? headB:cur1.next;
            cur2 = cur2 == null ? headA:cur2.next;

             //TODO :底下写法会陷入死循环！！！
//            cur1 = cur1.next== null ? headB:cur1.next;
//            cur2 = cur2.next == null ? headA:cur2.next;
        }
        return cur1;





    }
}
