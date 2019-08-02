package com.mine.test.leetcode;

/**
 * @author lj
 * @createDate 2019/8/2 11:50
 **/
public class PrintTool {


    public static void print(ListNode root){
        ListNode cur = root;
        while (cur!= null){
            System.out.print(cur.val + "--->");
            cur = cur.next;

        }
    }
}
