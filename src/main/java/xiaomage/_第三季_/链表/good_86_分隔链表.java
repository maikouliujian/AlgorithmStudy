package xiaomage._第三季_.链表;

import com.mine.test.leetcode.ListNode;

public class good_86_分隔链表 {


    /***
     * 思路1：重建链表
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        //新链表1
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;
        //新链表2
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyTail1 = dummyHead1;

        ListNode cur = head;
        while (cur!=null){
            if (cur.val < x){
                dummyTail.next = cur;
                dummyTail = cur;
            }else {
                dummyTail1.next = cur;
                dummyTail1 = cur;
            }

            cur = cur.next;

        }
        //TODO 循环结束dummyTail1.next=null,防止形成环
        dummyTail1.next = null;
        dummyTail.next = dummyHead1.next;
        //第二次扫描行不懂，此时链表已经被破坏
//        ListNode cur1 = head;
//        while (cur1!=null){
//            if (cur1.val >= x){
//                dummyTail.next = cur1;
//                dummyTail = cur1;
//            }
//            cur1 = cur1.next;
//        }


        return dummyHead.next;

    }
}
