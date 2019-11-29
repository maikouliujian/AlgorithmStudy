package com.mine.test.leetcode.str;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q344_反转字符串 {
    //TODO 异或  意思是取不同，相同为0，不同为1，只取不同
    /***
     编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

     不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

     你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。



     示例 1：

     输入：["h","e","l","l","o"]
     输出：["o","l","l","e","h"]

     示例 2：

     输入：["H","a","n","n","a","h"]
     输出：["h","a","n","n","a","H"]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/reverse-string
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/


    public static void main(String[] args) {

    }


    static class Solution {

        public void reverseString(char[] s) {
            //采用双指针交换
            int left = 0;
            int len = s.length;
            int right = len -1;
            int mid = (len >> 1) -1;

            while (left <= mid){
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }



        }
    }

}
