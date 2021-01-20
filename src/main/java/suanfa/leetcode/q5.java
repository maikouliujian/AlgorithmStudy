package suanfa.leetcode;

/**
 * @author lj
 * @createDate 2019/8/5 15:40
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q5 {

    //TODO 动态规划问题主要是找=============动态转移方程===========
    //后面的结果需要依赖前面的结果，则可以使用动态规划

    /**
     * 如果利用暴力法遍历所有字串是否回文的情况这道题肯定是 Time Limit Exceeded 的，那么我们是否可以把之前遍历的结果利用上呢，那么动态规划的想法就呼之欲出了，我们定义 dp[i][j] 的意思为字符串区间 [i, j] 是否为回文串，那么我们分三种情况：
     *      # todo 约定 ===> dp[i][j] 为 从i到j的子串 是否为回文串
     *     当 i == j 时，那么毫无疑问 dp[i][j] = true；
     *
     *     当 i + 1 == j 时，那么 dp[i][j] 的值取决于 s[i] == s[j]；
     *
     *     当 i + 1 < j 时，那么 dp[i][j] 的值取决于 dp[i + 1][j - 1] && s[i] == s[j]。
     *
     * 根据以上的动态转移方程，我们的问题即可迎刃而解，时间复杂度的话显而易见，也是 O(n^2)。
     * @param args
     */
    public static void main(String[] args) {
        String re = longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(re);


    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;

        int st = 0,end = 0;

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            //i = j时，满足条件
            dp[i][i] = true;

            for (int j = 0; j < i; j++) {
//                if (dp[j][i]){
//                    break;
//                }
                if (j + 1 == i){
                    dp[j][i] = chars[i] == chars[j];
                }else {
                    dp[j][i] = dp[j + 1][i -1] && chars[i] == chars[j];
                }

                //取j和i之间的距离最大的

                if (dp[j][i] && i-j > end -st){
                    end = i;
                    st = j;
                }
            }
        }

        return s.substring(st,end + 1);


    }


    class Solution {
        public String longestPalindrome(String s) {
            //动态规划
            //TODO 定义dp[i][j] 为从i到j的字串是否为回文子串
            char[] chars = s.toCharArray();
            int len = chars.length;
            boolean[][] dp = new boolean[len+1][len+1];
            int start = 0;
            int end = 0;
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
                for (int j = 0; j < i; j++) {
                    if (j +1 ==i ){
                        dp[j][i] = chars[j] == chars[i];
                    }else{
                        dp[j][i] = dp[j+1][i-1]&&chars[j] == chars[i];
                    }

                    //获取每一次的开始和结束值
                    if (dp[j][i] && i -j> end -start){
                        end =i;
                        start = j;
                    }
                }

            }
            return s.substring(start,end+1);

        }
    }
}
