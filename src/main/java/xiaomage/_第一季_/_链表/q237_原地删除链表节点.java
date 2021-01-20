package xiaomage._第一季_._链表;

import suanfa.leetcode.ListNode;

/***
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:



 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 示例 2:

 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class q237_原地删除链表节点 {

    public static void main(String[] args) {


    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 直接在原链表上操作
         * @param node
         */
        public void deleteNode(ListNode node) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
            next.next = null;

        }
    }
}
