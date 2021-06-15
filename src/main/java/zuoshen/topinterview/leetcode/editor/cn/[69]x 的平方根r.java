package zuoshen.topinterview.leetcode.editor.cn;//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 653 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution69 {
    public int mySqrt(int x) {
        if (x == 0)return 0;
        if (x < 3) return 1;
        long l = 0, r = x,a = 1;
        while (l <=r){
            long m = l +((r - l) >>1) ;

            if (x >= m * m){ //todo 向下取整，意思为取的离结果最近的答案！
                a= m;
                l = m +1;
            }else {
                r = m -1;
            }
        }
        return (int)a;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
