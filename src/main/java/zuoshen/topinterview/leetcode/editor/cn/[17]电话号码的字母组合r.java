package zuoshen.topinterview.leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1191 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    //todo 思路:暴力递归
    //构造电话
    public static final char[][] phones = new char[][]
            {{'a','b','c'}, {'d','e','f'},{'g','h','i'},{'j','k','l'},
                    {'m','o','n'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)return new ArrayList<>();
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        //path用于记录路径
        char[] path = new char[chars.length];
        //深度优先搜索
        helper(chars,0,path,result);
        return result;
    }

    private void helper(char[] chars, int i, char[] path, List<String> result) {
        //递归终止；
        if (i == chars.length){
            result.add(String.valueOf(path));
            return;
        }
        char cur = chars[i];
        //找到对应的数字的字符
        char [] nums = phones[cur- '2'];
        for (char num : nums) {
            path[i] = num;
            helper(chars,i+1,path,result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
