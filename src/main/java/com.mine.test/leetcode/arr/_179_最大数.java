package com.mine.test.leetcode.arr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author : 刘剑
 * @date : 2020/9/24 11:25 上午
 * @description
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _179_最大数 {


    static class Solution {

        /***
         *  TODO 按照字典排序的话，字典排序是从按位比较，不看位数
         * @param nums
         * @return
         *
         * //todo 1、数组转化为字符串；
         *        2、按照字典排序，然后合并
         */
        public String largestNumber(int[] nums) {
            //1、数组转化为字符串数组
            if (nums == null || nums.length == 0)return "";
            String[] strArr = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strArr[i] = String.valueOf(nums[i]);
            }
            //降序排序
            Arrays.sort(strArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    //TODO 3 和 30 应该是330，而不是303；
                    //TODO 只按照字典比是303，有问题的
                    String order1 = o1 + o2;
                    String order2 = o2 + o1;
                    return order2.compareTo(order1);
                }
            });
            System.out.println(Arrays.toString(strArr));
            //2、组装string
            StringBuilder sb = new StringBuilder();
            for (String s : strArr) {
                sb.append(s);
            }
            // 00 返回 0
            if (sb.charAt(0)=='0')
                return "0";
            return sb.toString();

        }
    }


    public String largestNumber1(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (String s :
                Arrays.stream(nums)
                        .boxed()
                        .map(Object::toString)
                        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                        .collect(Collectors.toList())) {
            sb.append(s);
        }

        String result = sb.toString();

        return result.startsWith("0") ? "0" : result;
    }

    public static void main(String[] args) {
        //int i = "9".compareTo("100000");   //8
        //int i = "100000".compareTo("9");   //-8
        //System.out.println(i);
        int arr[] = new int[]{3,30,34,5,9};   //9534330  而不是  9534303

        //输入00 返回0
        new Solution().largestNumber(arr);
    }
}
