package com.mine.test.leetcode.link;

import com.mine.test.leetcode.ListNode;
import scala.tools.nsc.backend.icode.Members;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q141 {
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
         * TODO 自己写的！！！
         * todo 链表环的问题：快慢指针
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode fast = head,show = head;

            while (fast!=null && fast.next!=null && show!=null){
                fast = fast.next.next;
                show = show.next;
                if (fast == show) return true;
            }

            return false;
        }
    }

}
