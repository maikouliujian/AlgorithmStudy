package com.mine.test.leetcode.leetcode.editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1218 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import suanfa.leetcode.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //todo 思路：多路归并 采用堆结构
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)return null;
        if (lists.length ==1)return lists[0];
        //todo 优先队列实现堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                //升序
                return o1.val - o2.val;
            }
        });
        //1、将每个元素加入堆,不为空的才加入
        for (ListNode list : lists) {
            if (list!=null)queue.add(list);
        }
        //2、从堆中取堆顶元素，依次加入链表中
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()){
            //todo 重建堆
            ListNode poll = queue.poll();
            cur.next = poll;
            cur= cur.next;
            //todo 不为空的才加入到堆中
            if (poll.next!=null){
                //todo 重建堆
                queue.add(poll.next);
            }

        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
