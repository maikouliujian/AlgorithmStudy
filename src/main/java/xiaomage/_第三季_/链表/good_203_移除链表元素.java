package xiaomage._第三季_.链表;

import com.mine.test.leetcode.ListNode;

import java.util.List;

public class good_203_移除链表元素 {


    /***
     * todo 思路1：记录前节点和当前节点进行追个判断删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode helper = new ListNode(-1);
        ListNode pre = helper;
        ListNode cur = head;
        pre.next = cur;

        while (cur!=null){
            if (cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }

        return helper.next;


    }


    /***
     * todo 思路2：想象成构建新链表，引入新链表头尾节点，head节点用来扫描原链表
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        //引入新链表头尾
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        while (head!=null){
            //只取不等的
            if (head.val != val){
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;



    }
}
