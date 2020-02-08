package xiaomage._第二季_.dp;


/****

 */

public class _最长公共子串 {

    public static void main(String[] args) {

        Solution s = new Solution();
        int re = s.longestCommonSubsequence("acd", "ad");
        System.out.println(re);

    }



    static class Solution {
        //dp[i][j]:text1的前i个元素和text2的前j个元素的最长公共子串！！！
        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
            char[] nums1 = text1.toCharArray();
            char[] nums2 = text2.toCharArray();

            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int max = dp[0][0];
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }
    }
}
