package suanfa.leetcode.arr;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2019/8/6 10:32
 * <p>
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class q88_合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution s = new Solution();
        s.mergeA(nums1, m, nums2, n);

        /***
         * [0]
         * 0
         * [1]
         * 1
         */

        //System.out.println(Arrays.toString(nums1));
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] tmp = new int[nums1.length];
            int l = 0;
            int r = 0;
            int i = 0;
            //一个是索引，一个是长度！！！
            while (l < m && r < n) {
                if (nums1[l] < nums2[r]) {
                    tmp[i++] = nums1[l++];
                } else {
                    tmp[i++] = nums2[r++];
                }
            }
            System.out.println(Arrays.toString(tmp));
            System.out.println(i);
            //补充剩余======
            while (l < m) {
                tmp[i++] = nums1[l++];
            }

            while (r < n) {
                tmp[i++] = nums2[r++];
            }

            for (int j = 0; j < tmp.length; j++) {
                nums1[j] = tmp[j];
            }
        }


        public void mergeA(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1;
            int len2 = n - 1;
            int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0) {
                // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
//            System.out.println(Arrays.toString(nums1));
//            System.out.println(Arrays.toString(nums2));
            // TODO add missing elements from nums2  此时num2中还有元素没放入num1中！！！
            // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);

//            System.out.println(Arrays.toString(nums1));
//            System.out.println(Arrays.toString(nums2));
        }
    }
}
