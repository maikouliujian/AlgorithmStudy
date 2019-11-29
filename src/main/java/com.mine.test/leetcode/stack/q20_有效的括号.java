package com.mine.test.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q20_有效的括号 {
    /***
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

     有效字符串需满足：

     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。

     注意空字符串可被认为是有效字符串。

     示例 1:

     输入: "()"
     输出: true

     示例 2:

     输入: "()[]{}"
     输出: true

     示例 3:

     输入: "(]"
     输出: false

     示例 4:

     输入: "([)]"
     输出: false

     示例 5:

     输入: "{[]}"
     输出: true

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/valid-parentheses
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */



    public static void main(String[] args) {


    }

    class Solution {
        //思路：遇到左括号进栈，右括号出栈
        public boolean isValid(String s) {
            int len = s.length();
            Stack<Character> stack =  new Stack<Character>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }else {
                    if (stack.isEmpty()) return false;
                    Character pop = stack.pop();
                    if (pop == '(' && c!= ')') return false;
                    if (pop == '{' && c!= '}') return false;
                    if (pop == '[' && c!= ']') return false;
                }
            }
            return stack.isEmpty();

        }
    }

}
