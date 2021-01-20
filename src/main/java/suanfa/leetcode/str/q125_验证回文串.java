package suanfa.leetcode.str;

/**
 * @author lj
 * @createDate 2019/8/7 10:55
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:

输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class q125_验证回文串 {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        //s = s.replaceAll("A","");

        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        System.out.println(s);

    }

    static class Solution {
        public boolean isPalindrome(String s) {

            //使用快慢指针
            s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
            char[] chars = s.toCharArray();
            int l = 0;
            int r = chars.length -1;
            while (l < r){
                if (chars[l++] != chars[r--]) return false;
            }

            return true;


        }
    }


}
