package suanfa.leetcode.link;


import suanfa.leetcode.ListNode;
import suanfa.leetcode.PrintTool;

/***

 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

 示例 1:

 输入: 4->2->1->3
 输出: 1->2->3->4

 示例 2:

 输入: -1->5->3->4->0
 输出: -1->0->3->4->5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _148_排序链表good {


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(6);


        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(5);


        ListNode x = new ListNode(9);
        ListNode y = new ListNode(12);
        ListNode z = new ListNode(99);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Solution s = new Solution();
        ListNode listNode = s.sortList(a);
        PrintTool.print(listNode);

    }


    static class Solution {
        //TODO 对链表进行排序，类比对数组进行排序，采用归并排序
        //TODO ：思路先切分，后合并
        public ListNode sortList(ListNode head) {
            //递归切分
            if (head == null || head.next == null) return head;
            //寻找链表中心点，采用快慢指针
            ListNode show = head;
            //TODO 注意是show还是show.next
            ListNode fast = show.next;
            while (fast!=null && fast.next!=null){
                fast = fast.next.next;
                show = show.next;
            }
            PrintTool.print(show);
            //到了这一步，show为中间节点
            //TODO 这里有一步，得断开链表
            ListNode r = sortList(show.next);
            show.next = null; //断开链表，不然会后死循环！！！
            ListNode l = sortList(head);
            return merge(l,r);

        }

        private ListNode merge(ListNode l, ListNode r) {
            /***
             * 合并两个链表
             */
            if (l == null)return r;
            if (r == null)return l;
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (r!= null && l!=null){
                if (r.val < l.val){
                    cur.next = r;
                    r= r.next;
                }else {
                    cur.next = l;
                    l= l.next;
                }
                cur = cur.next;
            }
            //将未合并的链表续上即可；
            if (l!=null){
                cur.next = l;
            }
            if (r!=null){
                cur.next = r;
            }
            return dummy.next;
        }
    }
}
