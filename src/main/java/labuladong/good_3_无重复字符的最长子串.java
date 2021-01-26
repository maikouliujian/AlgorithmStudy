package labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2021/1/26 2:28 下午
 * @description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class good_3_无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int bbbbb = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(bbbbb);
    }
    static class Solution {

        //todo：思路：滑动窗口===>
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int left = 0,right = 0;
            Map<Character,Integer> helper = new HashMap<>();
            int result = 0;
            while (right < chars.length){
                char cur = chars[right];
                helper.put(cur,helper.getOrDefault(cur,0)+1);
                right++;
                while (helper.get(cur) > 1){
                    char curLeft = chars[left];
                    helper.put(curLeft,helper.getOrDefault(curLeft,0)-1);
                    left++;
                }
                result = Math.max(result,right - left);

            }
            return result;
        }
    }
}
