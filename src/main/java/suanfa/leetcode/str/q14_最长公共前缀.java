package suanfa.leetcode.str;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"

示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q14_最长公共前缀 {
    public static void main(String[] args) {

    }

    //https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            //思路：先取出第一个字符串和剩余得每个字符串进行对比
            for (int i = 0; i < strs[0].length(); i++) {
                //取出每个字符
                char a = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                     if (i == strs[j].length() || strs[j].charAt(i) != a){
                         return strs[0].substring(0,i);
                     }
                }
            }

            return strs[0];
        }
    }


}
