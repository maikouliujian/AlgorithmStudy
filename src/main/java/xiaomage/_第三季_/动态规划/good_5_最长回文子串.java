package xiaomage._第三季_.动态规划;


/***
 * TODO 这个题是求子串，不是求长度！！！
 * TODO :回文即是对称，需要判断前后相等，所以dp 中需要界定 开始和结尾
 */
public class good_5_最长回文子串 {

    public static void main(String[] args) {
        new good_5_最长回文子串().longestPalindrome("babad");
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length()==1)return s;
        //TODO :这么进行不下去了

//        char[] chars = s.toCharArray();
//
//        //定义dp[i]为以s[i-1]结尾的最长回文子串的长度
//        int[] dp = new int[chars.length +1];
//        //初始化
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i < chars.length; i++) {
//            dp[i] =
//        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        //定义dp[i][j]为从i到j的子串是否为回文串
        boolean[][] dp = new boolean[len+1][len+1];
        int start = 0;
        int end = 0;
        //TODO 这种写法的问题所在====>要根据dp[i+1][j-1]推导dp[i][j]
        //TODO 想象递推矩阵，从左下角推导右上角，所以按照之前从上到下一行一行的推导是不行的！！！
        for (int i = 0; i < len; i++) {
            //当个字符本身是回文的！！！
            dp[i][i] = true;
            for (int j = i+1; j < len; j++) {
                //不对称，非回文
                if (chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else {
                    //dp[i][j] = dp[i+1][j-1];  该判断会出现问题，如果是bb，会出现i+1>j-1的情况，这是不合理的，所以需要单独判断
                    if (i +1 == j){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]){
                    if (j - i > end -start){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);


    }



    //TODO 时间复杂度n平方
    public String longestPalindromeDp(String s) {
        if (s == null || s.length() ==0 ||s.length()==1)return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        //定义dp[i][j]为从i到j的子串是否为回文串
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        //TODO ：从下到上倒推
        //由下到上（i由大到小）
        for (int i = len-1; i >= 0; i--) {
            //当个字符本身是回文的！！！
            dp[i][i] = true;
            //从左到右（j由小到大）
            for (int j = i+1; j < len; j++) {
                //不对称，非回文
                if (chars[i]!=chars[j]){
                    //可以省去，默认false
                    dp[i][j] = false;
                }else {
                    //dp[i][j] = dp[i+1][j-1];  该判断会出现问题，如果是bb，会出现i+1>j-1的情况，这是不合理的，所以需要单独判断
                    if (j-i == 1){   //长度等于2
                        dp[i][j] = true;
                    }else {
                        //长度大于2
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]){
                    if (j - i > end -start){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);


    }


    /***
     * 扩展中心法=====>以某个字符或者某个间隙为中心，向两边扩展来判断是否为回文串
     * 时间复杂度o(n)
     * @param s
     * @return
     */
    public String longestPalindromeEx(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        //从倒数第二个字符，以及其右边的间隙为中心进行遍历
        int maxLen = 1; //最长回文串长度
        int begin = 0;  //最长回文串长度初始索引；
        for (int i = len-2; i > 0; i--) {
            //以i字符为中心进行扩展，传入i-1和i+1；
            int length1 = getPalindromeLen(chars,i-1,i+1);
            //以i右边间隙为中心进行扩展，传入i和i+1；
            int length2 = getPalindromeLen(chars,i,i+1);
            //取最大
            int max = Math.max(length1,length2);
            if (max > maxLen){
                maxLen  = max;
                //TODO,根据长度和中心位置求初始索引
                begin = i - ((maxLen -1) >>1);
            }
        }

        //todo 还剩第一个间隙
        if (chars[0] == chars[1] && maxLen <2){
            begin= 0;
            maxLen = 2;
        }


        return new String(chars,begin,maxLen);
    }

    private int getPalindromeLen(char[] chars, int l, int r) {
        int len = chars.length;
        while (l >= 0 && r< len && chars[l] == chars[r]){
            l--;
            r++;
        }
        //TODO 注意长度的返回
        return r - l -1;
    }
}
