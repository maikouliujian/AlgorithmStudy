package suanfa.leetcode.str;

/**
 * @author : 刘剑
 * @date : 2021/1/18 3:29 下午
 * @description
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 *
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 */
public class _面试题_01_06_字符串压缩 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String aabcccccaaa = s.compressString("aabcccccaaa");
        String abbccd = s.compressString("abbccd");
        System.out.println(aabcccccaaa);
        System.out.println(abbccd);
    }

    static class Solution {
        //一次遍历，然后做计数
        public String compressString(String S) {
            if (S.length() == 0) return S;
            char[] chars = S.toCharArray();
            StringBuilder s  = new StringBuilder();
            //s.append(chars[0]);
            char curChar = chars[0];
            int num = 1;
            for (int i = 1; i < chars.length ; i++) {
                if (chars[i]==curChar){
                    num++;
                }else {
                    //不相等时再追加
                    s.append(curChar).append(num);
                    curChar = chars[i];
                    num=1;
                }
            }
            //最后追加一次
            s.append(curChar).append(num);
            return s.length() >= S.length()?S:s.toString();


        }
    }
}
