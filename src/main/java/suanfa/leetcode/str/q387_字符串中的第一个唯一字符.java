package suanfa.leetcode.str;

import java.util.HashMap;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.



注意事项：您可以假定该字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q387_字符串中的第一个唯一字符 {
    public static void main(String[] args) {

    }

    //https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/

    class Solution {
        public int firstUniqChar(String s) {
            //思路：第一次遍历找出每个字符得个数
            //      第二次遍历找出结果
            char[] chars = s.toCharArray();
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                map.put(c,map.getOrDefault(c,0) +1);
            }
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (map.get(c) == 1)
                    return i;
            }
            return -1;

        }
    }


}
