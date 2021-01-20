package suanfa.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2020/12/23 5:50 下午
 * @description
 */
public class _387_字符串中的第一个唯一字符 {
    class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0)return -1;
            char[] chars = s.toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            //扫一边，记录每个char的次数
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                map.put(aChar,map.getOrDefault(aChar,0)+1);
            }
            //扫第二遍得出结果
            for (int i = 0; i < chars.length; i++) {
                Integer cnt = map.getOrDefault(chars[i], 0);
                if (cnt == 1) return i;

            }
            return -1;
        }
    }
}
