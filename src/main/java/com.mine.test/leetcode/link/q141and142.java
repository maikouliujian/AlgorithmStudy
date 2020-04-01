package com.mine.test.leetcode.link;

import com.mine.test.leetcode.ListNode;


/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q141and142 {
    /***
     给定一个链表，判断链表中是否有环。

     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     如果 pos 是 -1，则在该链表中没有环。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/linked-list-cycle
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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


    }


    static class Solution {
        /***
         * TODO 141
         * todo 链表环的问题：快慢指针
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode fast = head,slow = head;

            while (fast!=null && fast.next!=null && slow!=null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) return true;
            }

            return false;
        }


        /***
         * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
         *
         * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
         * 如果 pos 是 -1，则在该链表中没有环。
         *
         * 说明：不允许修改给定的链表。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * TODO 142
         * todo 链表环的问题：快慢指针
         * todo 在141的基础上，有个计算公式。快慢指针相交的节点到入口节点的距离
         * todo 与
         * todo 从链表头到入口节点的距离是相等的！！！
         * @return
         */
        public ListNode detectCycle(ListNode head) {

            if (head == null || head.next == null) return null;
            ListNode fast = head,slow = head;
            boolean isHasCircle = false;

            while (fast!=null && fast.next!=null && slow!=null){
                fast = fast.next.next;
                slow = slow.next;
                //快慢指针的交点
                if (fast == slow) {
                    isHasCircle = true;
                    break;
                }
            }
            if (!isHasCircle) return null;
            //fast回到链表头
            fast = head;
//            while (fast!=null && slow!=null){
//                fast = fast.next;
//                slow = slow.next;
//                if (fast == slow) return slow;
//            }
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }

}
