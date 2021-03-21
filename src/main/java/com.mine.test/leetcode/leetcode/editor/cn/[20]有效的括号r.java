package com.mine.test.leetcode.leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2259 👎 0


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    //todo 对称 采用栈
    public boolean isValid(String s) {
        if ( s == null || s.length() <= 1)return false;
        Stack<Character> stack =  new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{'){
                //左括号入栈
                stack.push(aChar);
            }else {
                //右边括号出栈
                if (stack.isEmpty()) return false;
                Character poll = stack.pop();
                //todo 左右不等，直接false
                if (poll == '(' && aChar != ')')return false;
                if (poll == '[' && aChar != ']')return false;
                if (poll == '{' && aChar != '}')return false;
            }
        }
        //todo 最终判断栈是否清空了，如果全部配对成功，必须清空
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
