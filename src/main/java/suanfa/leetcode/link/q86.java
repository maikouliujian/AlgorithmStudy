package suanfa.leetcode.link;

import suanfa.leetcode.ListNode;
import suanfa.leetcode.PrintTool;

/**
 * @author lj
 * @createDate 2019/10/30 14:30
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q86 {

    public static void main(String[] args) {
        Solution s = new Solution();
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(3);
//        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
//        ListNode f = new ListNode(7);
//
//
//        ListNode x = new ListNode(100);
//        ListNode y = new ListNode(99);

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        PrintTool.print(a);
        ListNode re = s.partition(a, 3);
        System.out.println("====================");
        PrintTool.print(re);

    }


    static class Solution {
        /***
         * 思路：
         * TODO :将原链表进行拆分；维护一个小于分割值和一个大于分割值的链表
         * TODO ：然后合并两个链表
         *
         *
         * @return
         */
        public ListNode partition(ListNode head, int x) {
            ListNode great = new ListNode(-1);
            ListNode less = new ListNode(-1);
            ListNode tmp = head;
            ListNode gtmp = great;
            ListNode ltmp = less;
            while (tmp!=null){
                if (tmp.val >= x){
                    gtmp.next = tmp;
                    gtmp = gtmp.next;
                }else {
                    ltmp.next = tmp;
                    ltmp = ltmp.next;
                }
                tmp = tmp.next;
            }
            //可能会有环出现
            gtmp.next = null;  //断开环
            ltmp.next = great.next;

            return less.next;
        }
    }
}
