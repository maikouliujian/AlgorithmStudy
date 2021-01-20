package suanfa.leetcode;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q2 {
    /***
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;
        print(d);
        System.out.println();
        /*print(s.reverse(a));*/
        print(s.addTwoNumbers(a,d));



    }

    public static void print(ListNode root){
        ListNode cur = root;
        while (cur!= null){
            System.out.print(cur.val + "--->");
            cur = cur.next;

        }
    }


    static class Solution {
        public ListNode reverse(ListNode root){
            if (root == null) return null;
            if (root.next == null) return root;
            ListNode pre = null;
            ListNode tmp;
            ListNode cur = root;

            while (cur != null){
                    tmp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = tmp;
            }
            return pre;

        }

//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            /*//反转链表
//            int val1 = 0;
//            int val2 = 0;*/
//            int sum = 0;
//            ListNode tmp = new ListNode(0);  //作为结果链表的根节点
//            ListNode cur1 = l1,cur2 = l2, t = tmp;
//            while (cur1!= null || cur2!=null){
//                sum /= 10;
//                if (cur1!=null){
//                    sum += cur1.val;
//                    cur1 = cur1.next;
//                }
//                if (cur2!=null){
//                    sum += cur2.val;
//                    cur2 = cur2.next;
//                }
//                t.next = new ListNode(sum %  10);
//                t = t.next;
//            }
//
//            if (sum /10 != 0){
//                t.next = new ListNode(1);
//            }
//
//
//            return tmp.next;
//        }





        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode t1 = l1;
            ListNode t2 = l2;
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int sum = 0;

            while (t1!=null || t2!=null){
                //确定每一位的值
                sum /=10;
                if (t1!=null){
                    sum+= t1.val;
                    t1 = t1.next;
                }
                if (t2!=null){
                    sum+= t2.val;
                    t2 = t2.next;
                }
                cur.next = new ListNode(sum % 10);
                cur =  cur.next;

            }

            //处理最高位
            if (sum /10 == 1){
                cur.next = new ListNode(1);
            }

            return dummy.next;
        }
    }

}
