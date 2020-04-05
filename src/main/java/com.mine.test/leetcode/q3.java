package com.mine.test.leetcode;

/**
 * @author lj
 * @createDate 2019/8/1 17:35
 **/
public class q3 {
    /***
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

      //todo java char的范围为 -128 --127
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.lengthOfLongestSubstring("bbbabb");
        System.out.println(r);


    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
//            int len;
//            if (s == null || (len = s.length()) == 0) return 0;
//            //char字符为128最大
//            int[] hash = new int[128];
//            int pre = 0,max = 0;
//            for (int i = 0; i < len; i++) {
//                char a = s.charAt(i);
//                //如果字符已经 存在，则取出其位置
//                if (hash[a] > pre){
//                    pre = hash[a];
//                }
//                int result = i- pre + 1;
//                hash[a] = i +1;
//                if (result > max) max = result;
//            }
//            return max;




            //思路：找到相同字符的位置求差，取最大值
            /***
             * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。

             常用的表如下所示：

             int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
             int [128] 用于ASCII码
             int [256] 用于扩展ASCII码

             作者：LeetCode
             链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
             来源：力扣（LeetCode）
             著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
             */
            int len;
            if (s == null || (len = s.length()) == 0) return 0;
            if (1 == len) return 1;
            //初始化字符hash
            int [] hash = new int[128];
            //pre以i-1位置字符结尾的最长不重复字符串的开始索引（最左索引）
            int pre = 0;
            int max = 0;
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                //hash[c] i位置字符上一次出现的位置
                if (hash[c] > pre){
                    pre = hash[c];
                }
                int length = i - pre +1;
                //存储这个字符出现的位置
                hash[c]= i +1;
                if (length > max) max = length;



            }

            return max;

        }
    }


}
