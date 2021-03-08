package zuoshen.classics;

/**
 * @author : 刘剑
 * @date : 2021/3/7 5:57 下午
 * @description
 *
 * 括号有效配对是指：
 * 1）任何一个左括号都能找到和其正确配对的右括号
 * 2）任何一个右括号都能找到和其正确配对的左括号
 * 返回一个括号字符串中，最长的括号有效子串的长度
 */
public class _3括号有效配对 {
    //todo 思路：求最长的括号有效子串的长度；
    //todo 子串问题：一般考虑求以i结尾或者以i开头的子问题，然后使用dp进行求解
    public static int maxLength(String s) {
        if (s == null || s.length() < 2)return 0;
        //dp[i]:以i位置元素结尾的最长的括号有效子串的长度
        //状态转移方程为：dp[i]为
        // （1）if s[i] == '(' then 0
        // （2）if s[i] == ')':
        //        1)dp[i- dp[i-1] - 1] == '(' then dp[i-1] + 2 + dp[i- dp[i-1] - 2] else 0
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length];
        //dp[0] = 0;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')'){
                int pre = i- dp[i-1] - 1;
                if (pre >= 0 && arr[pre] == '('){
                    //注意索引越界的判断
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre -1]:0);
                }
            }
            max= Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("()()("));
    }
}
