package com.mine.test.leetcode.leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5097 👎 0


import sun.nio.cs.ext.MacHebrew;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //思路：从i位置向前递推
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 1) return 1;
        //思路：子串问题，首先考虑以i结尾的子串进行求解。即本题转为分别求以i结尾的无重复子串
        //求以i结尾的无重复子串需要考虑两个问题：1、上一次i位置元素出现的位置；2、i-1位置元素扩容长度的位置
        //这两个值的最大值，就是i能够扩容的最远位置;

        //要记录i位置元素上次出现的位置
        int[] map = new int[256];
        for (char aChar : chars) {
            map[aChar] = -1;
        }
        int max = 0;
        int pre = -1; //记录i-1元素能扩容的最远位置
        for (int i = 0; i < chars.length; i++) {
            pre = Math.max(pre,map[chars[i]]);
            max = Math.max(max,i- pre);
            map[chars[i]] = i;
        }
        return max;
    }

    //https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=21#wechat_redirect

   //todo 滑动窗口
    //todo 思路：先滑动右边，每次滑动右边看看左边窗口是否需要收敛（是否有重复元素），每次收敛完求出此时的长度
    public int lengthOfLongestSubstring1(String s) {
        //思路：滑动窗口
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 1) return 1;
        int[] map = new int[256];//记录窗口范围内各个元素出现个数；
        int left = 0,right = 0;
        int max = 0;
        while (right < chars.length){
            char cur = chars[right];
            map[cur]++;
            right++;  //指向了下次循环使用
            while (map[cur]>1){ //重复出现了
                char aChar = chars[left];
                map[aChar]--; //减去左边元素
                left++;
            }
            max = Math.max(max , right - left);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
