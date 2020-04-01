package xiaomage._第三季_.链表;

import com.mine.test.leetcode.ListNode;

public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int add = 0;
        //构建新链表
        ListNode newNode = new ListNode(-1);
        ListNode cur = newNode;
        while (l1!=null || l2!=null){
            int v = 0;
            if (l1!=null){
                v +=l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                v+=l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode((v+add)%10);
            add = (v+add)/10;
            cur = cur.next;
        }

        //还有一种情况[5] [5]
        if (add > 0){
            cur.next = new ListNode(add);
        }
        return newNode.next;

    }
}
