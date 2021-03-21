package com.mine.test.leetcode.leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1513 👎 0


import sun.nio.cs.ext.MacHebrew;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    //todo 固定住最外层，以第一个元素的长度进行固定
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 )return"";
        if (strs.length == 1)return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            //和其他字符串对比
            for (int j = 1; j < strs.length; j++) {
                //todo
                // 1、相等就跳过，不相等就退出；2、达到了某一个字符串的末尾，也退出
                if (strs[j].length() == i || cur != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String A = longestCommonPrefix(new String[]{"flower","flower","flower","flower"});
        System.out.println(A);
    }

    //todo 把第一个拎出来，用它在其他每个串进行对比，选择index最小的；
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0 )return"";
        if (strs.length == 1)return strs[0];
        char[] chars = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            char[] chars1 = strs[i].toCharArray();
            int index = 0;
            //todo 不能越界
            while (index < chars.length && index < chars1.length){
                if (chars[index] != chars1[index]){
                    break;
                }
                index++;
            }
            min = Math.min(min,index);
            if (min == 0)return "";
        }
        return strs[0].substring(0,min);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
