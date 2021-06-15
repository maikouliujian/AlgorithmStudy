package zuoshen.topinterview.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3320 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    //todo 子串问题 求以i结尾的回文串，一个变量搞不定，引入另一个变量
    //dp[i][j] : 从i到j的串是否为回文串
    public String longestPalindrome(String s) {
        if (s == null)return null;
        if (s.length() == 1)return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean [][] dp = new boolean[len][len];
        //int max = 0;

        //因为递推dp[i][j] 需要借助 dp[i+1][j-1]，所以常规的顺序遍历是不行的；
        //TODO 所以固定结尾j
        int start = 0,end = 0;
        for (int j = 0; j < chars.length ; j++) {
            //情况1：单个字符肯定是回文的
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (j == i + 1){
                    dp[i][j] = chars[i] == chars[j];
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j];
                }
                if (dp[i][j]){
                    if ((j - i) >(end - start)){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
