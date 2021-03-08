package suanfa.leetcode.link;

import suanfa.leetcode.ListNode;
import suanfa.leetcode.PrintTool;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lj
 * @createDate 2019/10/30 14:30
 *
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
1->4->5,
1->3->4,
2->6
]
输出: 1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class good_q23_合并K个升序链表 {

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
        ListNode c = new ListNode(6);


        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(5);


        ListNode x = new ListNode(9);
        ListNode y = new ListNode(12);
        ListNode z = new ListNode(99);


        a.next = b;
        b.next = c;
        //c.next = d;
        d.next = e;
        e.next = f;

        x.next = y;
        y.next = z;

//        PrintTool.print(a);
//        ListNode re = s.partition(a, 3);
//        System.out.println("====================");
//        PrintTool.print(re);
        ListNode[] lists = {a,d,x};

        ListNode merge = s.mergeKLists(lists);
        PrintTool.print(merge);

    }


    static class Solution {
        /***
         * 思路：
         * TODO :采用分而治之
         * TODO :分治法：时间复杂度为：nlog(k)
         * todo 时间复杂度分析：两两归并，每个结点会被归并 log(k) 次，所以总的时间复杂度为 O(nlog(k))。 n为总节点数
         *
         *
         *  TODO :   分解原问题为若干个子问题，这些子问题是原问题的规模较小的实例；
         *           递归求解这些子问题，如果规模足够小，则直接求解；
         *           合并这些子问题的解即可得到原问题的解。
         *
         *
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;
            if (len == 1) return lists[0];

            return helper(lists, 0, len - 1);

        }

        //     0    ,   2
        private ListNode helper(ListNode[] lists, int start, int end) {
            //递归终止条件
            if (start > end) return null;
            if (start == end) return lists[start];

            int mid = start + (end - start) / 2;
            ListNode left = helper(lists, start, mid);
            ListNode right = helper(lists, mid + 1, end);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            //合并逻辑
            if (left == null) return right;
            if (right == null) return left;

            ListNode dummp = new ListNode(-1);
            ListNode tmp = dummp;

            while (left != null && right != null) {
                if (left.val > right.val) {
                    tmp.next = right;
                    right = right.next;
                } else {
                    tmp.next = left;
                    left = left.next;
                }
                tmp = tmp.next;
            }
            //跳出循环，必定有一方为null；
            if (left == null) tmp.next = right;
            if (right == null) tmp.next = left;

            return dummp.next;
        }


        /*public ListNode mergeTwoLinked(ListNode left, ListNode right) {
            if (left == null) return right;
            if (right == null) return left;
            ListNode l = left;
            ListNode r = right;
            //（1）新建一个头节点，将两个链表中的元素向该节点上累加；
            //（2）返回最终的头节点
            ListNode headPointer = new ListNode(-1);
            ListNode cur = headPointer;
            while (l != null && r != null) {
                if (l.val < r.val) {
                    cur.next = l;
                    l = l.next;
                } else {
                    cur.next = r;
                    r = r.next;
                }
                cur = cur.next;
            }

            if (l != null) {
                cur.next = l;   //将未合并的链表续上即可；
            }
            if (r != null) {
                cur.next = r;
            }

            return headPointer.next;

        }*/

        //todo 采用堆进行排序
        public ListNode mergeKLists1(ListNode[] lists) {
            if (lists == null)return null;
            if (lists.length == 1) return lists[0];
            //堆===优先队列
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val  - o2.val;
                }
            });
            for (ListNode list : lists) {
                //注意
                if (list!=null)
                queue.add(list);
            }

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            while (!queue.isEmpty()){
                tail.next = queue.poll();
                tail = tail.next;
                //动态向堆中添加元素
                if (tail.next!=null)queue.add(tail.next);
                tail.next = null;//断开无用链接
            }
            return dummy.next;
        }
    }



}
