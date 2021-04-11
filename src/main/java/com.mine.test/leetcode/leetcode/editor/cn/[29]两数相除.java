package com.mine.test.leetcode.leetcode.editor.cn;//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 535 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution29 {
    public static void main(String[] args) {
//        int add = add(3, 4);
//        System.out.println(add);
//        int minus = minus(2, 4);
//        System.out.println(minus);
        int multi = multi(4, 5);
        System.out.println(multi);
    }
    public int divide(int dividend, int divisor) {

return -1;
    }

    //todo 求两数之和
    public static int add(int a,int b){
        int sum = a;
        //直到有进位的和为0；
        while (b!=0){
            sum= a^b; //无进位的和
            b = (a&b)<<1; //只进位的和；
            a = sum;
        }
        return sum;
    }

    //todo a - b   ==== a + (-b)
    public static int minus(int a,int b){
        return add(a,neg(b));

    }

    //todo 求-b
    //取反 + 1为对应的负数
    //https://blog.csdn.net/hahahahhahha/article/details/108017612
    private static int neg(int b) {
        return add(~b,1);
    }


    private static int multi(int a, int b) {
        int res = 0;
        while (b!=0){
            if ((b&1)!=0){
                res = add(res,a);
            }
            a<<=1;//向左移动补0；
            b>>=1;//向右移动；
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
