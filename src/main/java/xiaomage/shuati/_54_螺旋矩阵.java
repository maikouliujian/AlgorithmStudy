package xiaomage.shuati;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {


    //二维数组====>矩阵
    //TODO 想要螺旋遍历矩阵，需要维护四个指针
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix[0].length-1;

        while (top <= bottom && left<= right){
            for (int i = left; i <=right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <=bottom ; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            //避免重复添加
            if (top > bottom || left > right)break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >=top ; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
   return res;
    }
}
