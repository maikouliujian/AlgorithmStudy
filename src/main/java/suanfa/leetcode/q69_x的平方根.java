package suanfa.leetcode;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q69_x的平方根 {
    /***
     实现 int sqrt(int x) 函数。

     计算并返回 x 的平方根，其中 x 是非负整数。

     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

     示例 1:

     输入: 4
     输出: 2

     示例 2:

     输入: 8
     输出: 2
     说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/sqrtx
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public static void main(String[] args) {

            System.out.println(mySqrt2(8));
        }

        public static int mySqrt(int x) {
            //使用二分法
            /*if (x == 0) return x;
            long l = 1;
            long r = x /2 ;
            while (l < r){
                //TODO 取右中位数
                long mid = l + (r -l +1) /2;
                long tmp = mid * mid;
                if (tmp > x){
                    r = mid -1;
                }else {
                    l = mid;
                }

            }

            return (int)l;*/


            //使用牛顿迭代法
            long a = x;
            while (a * a > x){
                a = (a + x/a) /2;
            }

            return (int)a;

        }


        public static int mySqrt2(int x) {
            //二分法求平方根
            long low = 0;
            long high  = x;
            long middle = -1;
            while(high - low > 0){
                middle = low + (high - low) >> 1;
                if(x /middle > middle){
                    low = middle+1;
                }else if(x /middle < middle){
                    high = middle -1;
                }else{
                    return (int)middle;
                }

            }
            return (int)middle;

        }

        public static double mySqrtA(int x) {
            //使用二分法
            /*if (x == 0) return x;
            long l = 1;
            long r = x /2 ;
            while (l < r){
                //TODO 取右中位数
                long mid = l + (r -l +1) /2;
                long tmp = mid * mid;
                if (tmp > x){
                    r = mid -1;
                }else {
                    l = mid;
                }

            }

            return (int)l;*/


            //使用牛顿迭代法
            double a = x;
            double error = Math.exp(-10);
            /*while (a * a > x){
                a = (a + x/a) /2;
            }*/

            while (Math.abs((a * a - x)/a*a) > error){
                a = (a + x/a) /2.0;
            }
            return a;

        }
    }

}
