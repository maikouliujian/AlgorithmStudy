package labuladong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2021/1/26 2:04 下午
 * @description
 *
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 *     字母异位词指字母相同，但排列不同的字符串。
 *     不考虑答案输出的顺序。
 *
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _438_找到字符串中所有字母异位词 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            //滑动窗口问题
            //子串相等：要求每个字符相等，且个数相等
            int left = 0,right = 0;
            Map<Character,Integer> needs = new HashMap<>();
            char[] shortStr = p.toCharArray();
            char[] longStr = s.toCharArray();
            for (char c : shortStr) {
                needs.put(c,needs.getOrDefault(c,0)+1);
            }
            Map<Character,Integer> windows = new HashMap<>();
            int match = 0;
            List<Integer> result = new ArrayList<>();
            while (right < longStr.length){
                char cur = longStr[right];
                if (needs.containsKey(cur)){
                    windows.put(cur,windows.getOrDefault(cur,0)+1);
                    if (windows.get(cur).equals(needs.get(cur))){
                        match++;
                    }
                }
                right++;
                while (match == needs.size()){
                    //判断是否为结果
                    if (right - left == p.length()){
                        result.add(left);
                    }
                    char curleft = longStr[left];
                    if (needs.containsKey(curleft)){
                        windows.put(curleft,windows.get(curleft)-1);
                        if (windows.get(curleft) < (needs.get(curleft))){
                            match--;
                        }
                    }
                    left++;
                }
            }
            return result;

        }
    }
}
