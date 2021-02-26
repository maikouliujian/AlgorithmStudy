package zuoshen.study.exec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2021/1/26 11:38 上午
 * @description
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 */
public class _76_最小覆盖子串 {
    public static void main(String[] args) {
        Solution s  = new Solution();
        //String s1 = s.minWindow("ADOBECODEBANC", "ABC");
        String s1 = s.minWindow("AB", "A");
        System.out.println(s1);
    }

    static class Solution {
        //todo 思路滑动窗口，先移动窗口右边，找到合适的子串，再移动左边，缩减子串长度
        //todo 以此循环
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";
            //由于满足条件是无序的，所以采用hash判断，key以及其对应的个数
            Map<Character,Integer> needs = new HashMap<>();
            char[] shortStr = t.toCharArray();
            char[] longStr = s.toCharArray();
            for (char aChar : shortStr) {
                needs.put(aChar,needs.getOrDefault(aChar,0)+1);
            }
            Map<Character,Integer> windows = new HashMap<>();
            int right = 0,left = 0;
            //找到匹配的个数
            int match = 0;
            int minLen = Integer.MAX_VALUE;
            int start = 0;
            while (right < longStr.length){
                char cur = longStr[right];
                if (needs.containsKey(cur)){
                    windows.put(cur,windows.getOrDefault(cur,0)+1);
                    //k v都相等才满足
                    if (needs.get(cur).equals(windows.get(cur))){
                        match++;
                    }
                }
                right++;
                //移动窗口左边,是为了缩短子串的长度，直到子串不满足条件为止
                while (match == needs.size()){
                    if (right - left < minLen){
                        start = left;
                        minLen = right - left;
                    }
                    char curleft = longStr[left];
                    if (needs.containsKey(curleft)){
                        windows.put(curleft,windows.get(curleft)-1);
                        if (windows.get(curleft) < needs.get(curleft)){
                            match--;
                        }
                    }
                    left++;
                }
            }
            return minLen == Integer.MAX_VALUE?"":s.substring(start,start+minLen);

        }
    }
}
