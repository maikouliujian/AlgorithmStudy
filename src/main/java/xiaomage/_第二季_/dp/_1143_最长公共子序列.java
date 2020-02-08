package xiaomage._第二季_.dp;


import sun.nio.cs.ext.MacHebrew;

/****
 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

 若这两个字符串没有公共子序列，则返回 0。



 示例 1:

 输入：text1 = "abcde", text2 = "ace"
 输出：3
 解释：最长公共子序列是 "ace"，它的长度为 3。

 示例 2:

 输入：text1 = "abc", text2 = "abc"
 输出：3
 解释：最长公共子序列是 "abc"，它的长度为 3。

 示例 3:

 输入：text1 = "abc", text2 = "def"
 输出：0
 解释：两个字符串没有公共子序列，返回 0。



 提示:

 1 <= text1.length <= 1000
 1 <= text2.length <= 1000
 输入的字符串只含有小写英文字符。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _1143_最长公共子序列 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] coins = new int[]{2};

    }



    static class Solution {
        //dp[i][j]:text1的前i个元素和text2的前j个元素的最长公共子序列
        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
            char [] nums1 = text1.toCharArray();
            char [] nums2 = text2.toCharArray();

            int [][] dp = new int[nums1.length+1][nums2.length+1];
            dp[0][0] = 0;
            for (int i = 1; i <= nums1.length; i++) {
                //初始化
                dp[i][0] = 0;
                for (int j = 1; j <= nums2.length; j++) {
                    dp[0][j] = 0;
                    if (nums1[i-1] == nums2[j-1]){
                        dp[i][j] =  dp[i-1][j-1]+1;
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }

                }
            }

            return dp[nums1.length][nums2.length];

        }




        //dp[i][j]:text1的前i个元素和text2的前j个元素的最长公共子序列

        /***
         * 优化1   降低空间复杂度   因为每次只需要关注 动态规划矩阵 当前行和上一行
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence1(String text1, String text2) {
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
            char [] nums1 = text1.toCharArray();
            char [] nums2 = text2.toCharArray();

            int [][] dp = new int[2][nums2.length+1];
            //dp[0][0] = 0;
            for (int i = 1; i <= nums1.length; i++) {
                //初始化
                //dp[i][0] = 0;
                int row = i%2;
                int preRow = (i-1)%2;
                for (int j = 1; j <= nums2.length; j++) {
                    //dp[0][j] = 0;
                    if (nums1[i-1] == nums2[j-1]){
                        dp[row][j] =  dp[preRow][j-1]+1;
                    }else {
                        dp[row][j] = Math.max(dp[preRow][j],dp[row][j-1]);
                    }

                }
            }

            return dp[nums1.length%2][nums2.length];

        }
    }
}
