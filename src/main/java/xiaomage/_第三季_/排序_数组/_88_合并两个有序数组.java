package xiaomage._第三季_.排序_数组;


import java.util.Arrays;

/***
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。



 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。



 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _88_合并两个有序数组 {
    public static void main(String[] args) {
        int num1[] = new int[]{1,2,3,0,0,0};
        int num2[] = new int[]{2,5,6};
        new _88_合并两个有序数组().merge(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));
    }


    /***
     * 思路1：从右向左遍历
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = nums1.length-1;
        int index1 =m-1;
        int index2 = n-1;
//        while (index1>=0 && index2 >=0){  //这步是有问题的！！！
//            if (nums1[index1] > nums2[index2]){
//                nums1[insertIndex--] = nums1[index1--];
//            }else {
//                nums1[insertIndex--] = nums2[index2--];
//            }
//        }

        //考虑临界情况
        while (index2 >=0){
            if (index1 >=0 && nums1[index1] > nums2[index2]){
                nums1[insertIndex--] = nums1[index1--];
            }else {
                nums1[insertIndex--] = nums2[index2--];
            }
        }

    }



}
