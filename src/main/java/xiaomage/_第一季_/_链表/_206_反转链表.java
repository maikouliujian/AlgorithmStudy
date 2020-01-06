package xiaomage._第一季_._链表;


import com.mine.test.leetcode.ListNode;

/***
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL

 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _206_反转链表 {


    public static void main(String[] args) {


    }


    class Solution {
        public ListNode reverseList(ListNode head) {
             if (head == null || head.next == null) return head;
//             ListNode pre = head;
//             ListNode cur = head.next;
//             ListNode next = null;
//             while (cur!=null){
//                 next = cur.next;
//                 cur.next = pre;
//                 pre = cur;
//                 cur = next;
//             }
//            pre.next = null;
//
//             return pre;
            //引入一个新节点
            ListNode newNode = null;
            while (head!=null){
                ListNode tmp = head.next;
                head.next = newNode;
                newNode = head;
                head = tmp;
            }
            return newNode;
        }

        //递归：主要是考虑清除递归的含义

        public ListNode reverseListRec(ListNode head) {
           if (head == null || head.next == null) return head;
           ListNode newhead = reverseListRec(head.next);
           head.next.next = head;
           head.next = null;
           return newhead;

        }


    }


}
