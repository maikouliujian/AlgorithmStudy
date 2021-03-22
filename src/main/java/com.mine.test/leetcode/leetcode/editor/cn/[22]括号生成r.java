package com.mine.test.leetcode.leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1646 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
    //todo 排列组合问题，选用dfs解决，注意剪枝（左口号开头才有意义）
    public static List <String> generateParenthesis(int n) {
         if (n == 0) return new ArrayList<>();
        List <String> result = new ArrayList<>();
        //n代表生成括号的对数
        char[] path = new char[n << 1];
        helper(0,result,path,n,n);
        return result;

    }

    //todo 递归含义代表：根据左括号剩余数和右括号剩余数，还能构造的合理括号组合
    private static void helper(int idx,List<String> result, char[] path, int leftRest, int rightRest) {
        if (idx == path.length){
            //添加元素
            result.add(String.valueOf(path));
        }else {

            //todo 剪枝;leftRest > rightRest代表 右括号比左括号多，是不合法的
            if (leftRest > rightRest)return;
            if (leftRest > 0){
                path[idx] = '(';
                helper(idx+1,result,path,leftRest-1,rightRest);
            }

            if (rightRest > 0){
                path[idx] = ')';
                helper(idx+1,result,path,leftRest,rightRest-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
