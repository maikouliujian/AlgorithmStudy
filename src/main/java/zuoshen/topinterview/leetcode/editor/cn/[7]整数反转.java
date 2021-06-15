package zuoshen.topinterview.leetcode.editor.cn;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2588 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution7 {

    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
        System.out.println(-123/10);
    }

    //todo 思路：求int的每一位 x % 10
    public static int reverse(int x) {
        int result = 0;
        //todo 无论正负，先转位正数，保留符号
        int t  = x > 0 ? x:-x;
        while (t > 0){
            result = result*10 + (t%10);
            t/=10;
        }
        return x > 0 ? result: -result;


    }


    public static int reverse1(int x) {
        long result = 0;
        //todo 不需要转为正数，本身自带符号
        //   除和模 都自带符号
        //   -123/10 = -12   -123%10  = -3   -123 = 10 * -12 +（-3）// -0 = 0
        while (x !=0){
            result = result*10 + (x%10);
            x/=10;
        }
        return (int)result==result? (int)result:0;


    }


    public static int reverse2(int x) {
        //todo 处理正数和负数范围，统统转化为负数，因为负数的范围比正数大1；
        //判断正负,负数右移31位的最高位是1；
        /***
         * >>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
         *
         * 4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
         *
         * >>>：无符号右移。无论是正数还是负数，高位通通补0。
         */
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        int m = Integer.MIN_VALUE /10;
        int o = Integer.MIN_VALUE %10;
        int res = 0;
        while (x != 0){
            //todo 判断越界
            if (res < m || (res == m && (x % 10) < o)){
                return 0;
            }
            res = res * 10 + x % 10;
            x/=10;
        }
        return neg? res:-res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
