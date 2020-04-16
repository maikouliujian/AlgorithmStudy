package com.mine.test.leetcode.arr;

import java.util.*;

/**
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author lj
 * @createDate 2020/4/16 11:06
 **/
public class good_56_合并区间 {


//    public int[][] merge(int[][] intervals) {
////        int len = intervals.length;
////        int mid = len >> 1;
////        List<int[]> result = new ArrayList<>();
////        for (int i = 0; i < mid; i++) {
////             int j = len -i -1;
////             int[] pre = intervals[i];
////             int prelenIndex = 1;
////             int[] post = intervals[j];
////             int postlenIndex = 1;
////
////             if (pre[0]>=post[0] && pre[prelenIndex] <= post[postlenIndex]){
////                 result.add(post);
////             }else if (post[0]>=pre[0] && post[postlenIndex] <= pre[prelenIndex]){
////                 result.add(pre);
////             }else if (post[0] >= pre[0] && pre[1] >= post[0]){
////                 result.add(new int[]{pre[0],post[1]});
////             }else if (post[0] <= pre[0] && pre[1] <= post[0]){
////                 result.add(new int[]{post[0],pre[1]});
////             }
////
////        }
////
////        return result.toArray(new int[0][]);
//        //Arrays.copyOf(res, idx + 1);
//
//    }

    //TODO : 先排序后合并
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;
        //先对数组中第一个元素进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        //返回结果
        int[][] re = new int[len][2];
        //指向结果数组得索引
        int idx = -1;
        //构造结果数组！！！
        for (int[] interval : intervals) {
            //不合并
            if (idx == -1 || re[idx][1] < interval[0]){
                re[++idx] = interval;
            }else {
                //合并,只改变第二个值即可
                re[idx][1] = Math.max(re[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(re,idx+1);







    }
}
