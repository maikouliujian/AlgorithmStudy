package suanfa.leetcode;

/**
 * @author : 刘剑
 * @date : 2020/9/28 10:04 上午
 * @description
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _171_Excel表列序号 {


    class Solution {
        /***
         * TODO 1、单个字符的数值为：char(str) - 'A' + 1
         *      2、 本题为26进制
         * @param s
         * @return
         */
        public int titleToNumber(String s) {
           int re = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int val = chars[i] - 'A' +1;
                re= re*26 + val;
            }
            return  re;

        }
    }
}
