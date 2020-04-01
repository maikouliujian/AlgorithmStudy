package xiaomage._第三季_.排序_数组;


/***
 * 977. 有序数组的平方

 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。



 示例 1：

 输入：[-4,-1,0,3,10]
 输出：[0,1,9,16,100]

 示例 2：

 输入：[-7,-3,2,3,11]
 输出：[4,9,9,49,121]



 提示：

 1 <= A.length <= 10000
 -10000 <= A[i] <= 10000
 A 已按非递减顺序排序。


 */
public class _977_有序数组的平方 {


    //思路：采用双指针
    //前提：给定一个按非递减顺序排序的整数数组，这种才可以用双指针
    public int[] sortedSquares(int[] A) {
        int result [] = new int[A.length];
        int l = 0;
        int r = A.length-1;
        //新数组先放大值
        int cur = r;

        while (l<=r){
            int lv = Math.abs(A[l]);
            int rv = Math.abs(A[r]);

            if (lv>rv){
                result[cur--] = lv * lv;
                l++;
            }else {
                result[cur--] = rv * rv;
                r--;
            }
        }
        return result;

    }
}
