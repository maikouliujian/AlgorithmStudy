package suanfa.jianzhioffer;

/**
 * @author lj
 * @createDate 2019/8/21 11:01
 *
 * 例子1：
 * 剑指Offer（第二版）面试题14：剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成m段
 * (m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],…,k[m].请问k[0]k[1]…*k[m]可能的最大乘积是多少？
 **/
public class q14 {

    public static void main(String[] args) {
        int cutting = cutting(8);
        System.out.println(cutting);

    }

    public static int cutting(int n) {
        //1、是求最优解，考虑dp
        //2、通过从上到下，或者从下到上分析，状态转移方程：状态转移方程：
        // f(n)=Max{f(n-i)*f(i)} i={1,2,3,…,n/2} # todo 逐级递推
        //3、边界问题：
        /***
         * 底层的边界问题说的就是最小的前几个数值的f(n)的值，本题中就是f(0)、f(1)、f(2)、f(3)的值
         * 对于f(0)，长度为0的绳子，没办法剪，没有意义
         * 对于f(1)，长度为1的绳子，没办法剪，设为1
         * 对于f(2)，长度为2的绳子，只有一种剪法，剪成两段长度为1的绳子，但剪后的乘积为1，比自身更小；如果不是求自身的值，要求乘积最大值的话就没必要剪。
         * 对于f(3)，长度为3的绳子，只有一种剪法，剪成两段长度为1和2的绳子，但剪后的乘积为2，比自身更小；如果不是求自身的值，要求乘积最大值的话也没必要剪。
         *  ————————————————
         * 版权声明：本文为CSDN博主「食鱼酱」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
         * 原文链接：https://blog.csdn.net/weixin_38278878/article/details/80037455
         */

        //先判断终止条件
        //n <= 1属于无意义
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        //=========================================
        int[] memo = new int[n +1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 3;

        int maxResult = 0;
        //记忆化

        for (int i = 4; i <= n; i++) {
            int max = 0;//寻找memo[i] ==> 临时最大值
            //每一个n对应的多种状态
            for (int j = 1; j <= i/2 ; j++) {
                int tmp = memo[j] * memo[i-j];
                max = max > tmp ? max : tmp;
            }
            memo[i] = max;
        }
        maxResult = memo[n];
        return maxResult;
    }
}
