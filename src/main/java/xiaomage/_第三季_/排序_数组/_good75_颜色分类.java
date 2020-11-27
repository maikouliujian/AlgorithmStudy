package xiaomage._第三季_.排序_数组;


import java.util.Arrays;

/***
 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]

 进阶：

 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-colors
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _good75_颜色分类 {
    public static void main(String[] args) {
    }

    //荷兰国旗问题

    /***
     * 思路：三指针问题：left指针收集0，right指针收集2，cur指针进行扫描
     *        cur指针大于right结束
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left=0,cur = 0;
        int right = nums.length-1;
        while (cur<=right){
            int value = nums[cur];
            if (value ==0){
                swap(left++,cur++,nums);
            }else if (value == 1){
                cur++;
            }else {
                //todo 这里cur不能--，是因为如果cur是2，right是1，这么一交换，并且cur--的话，那么1就永远在左边了！！！
                swap(right--,cur,nums);
            }
        }

    }

    private void swap(int left, int right,int[] nums) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right]=tmp;
    }


}
