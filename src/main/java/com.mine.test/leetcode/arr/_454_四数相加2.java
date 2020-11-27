package com.mine.test.leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 刘剑
 * @date : 2020/11/27 8:40 下午
 * @description
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _454_四数相加2 {

    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            if (A == null||B == null || C== null||D== null) return 0;
            Map<Integer,Integer> map  = new HashMap<>();
            //1、两两分组，2、采用hashmap计数
            for (int a : A) {
                for (int b : B) {
                    map.put(a+b,map.getOrDefault(a+b,0)+1);
                }
            }

            int res = 0;
            for (int c :C) {
                for (int d : D) {
                    if (map.containsKey(-c-d)){
                        res+=map.get(-c-d);
                    }
                }
            }
            return res;
        }
    }
}
