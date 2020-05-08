package com.mine.test.leetcode.贪心;

/**
 * @author lj
 * @createDate 2020/5/8 11:47
 **/
public class 面试题14_II_剪绳子 {



    //思路：由于数据大，需要取模，使用贪心，优先切3
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n ==3 )return 2;
        int mod = 1000000007;
        long res = 1;
        while (n > 4){
            n-=3;  //每次取3
            res = res*3 % mod;

        }
        return (int)(res*n%mod);
    }
}
