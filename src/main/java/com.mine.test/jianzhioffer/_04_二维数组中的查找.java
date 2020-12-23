package com.mine.test.jianzhioffer;

/**
 * @author : 刘剑
 * @date : 2020/12/22 10:01 上午
 * @description
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _04_二维数组中的查找 {


    class Solution {
        //此题要抓住行列递增的特性，倒着找速度更快
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int rows = matrix.length -1; //行
            int columns = matrix[0].length -1; //列
            int curR = 0,curC = columns;
            //从第一行最后一列找起
            while (curR <= rows && curC >=0 ){
                if (matrix[curR][curC] > target){
                    curC--;
                }else if (matrix[curR][curC] < target){
                    curR++;
                }else {
                    return true;
                }

            }
            return false;
        }
    }

}
