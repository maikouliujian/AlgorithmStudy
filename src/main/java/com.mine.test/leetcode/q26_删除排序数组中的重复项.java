package com.mine.test.leetcode;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q26_删除排序数组中的重复项 {
    //TODO 异或  意思是取不同，相同为0，不同为1，只取不同
    /***
     给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     示例 1:

     给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。

     示例 2:

     给定 nums = [0,0,1,1,1,2,2,3,3,4],

     函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

     你不需要考虑数组中超出新长度后面的元素。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        int[] arr = {0,0,0,0,0,0,1};
         new Solution().removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));

    }


    static class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            //采用双指针进行
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                //相等就跳过
                if (nums[i] != nums[j]){
                    i++;
                    nums[i] = nums[j];

                }
            }
            return i+1;
        }


//        public int[] removeDuplicates(int[] nums) {
//            if (nums.length == 0) return new int[]{};
//            //采用双指针进行
//            int i = 0;
//            for (int j = 1; j < nums.length; j++) {
//                //相等就跳过
//                if (nums[i] != nums[j]){
//                    i++;
//                    nums[i] = nums[j];
//
//                }
//            }
//            return i+1;
//        }
    }

}
