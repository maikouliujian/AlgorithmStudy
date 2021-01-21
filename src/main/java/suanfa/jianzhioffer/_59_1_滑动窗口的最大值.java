package suanfa.jianzhioffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author : 刘剑
 * @date : 2021/1/20 7:38 下午
 * @description
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _59_1_滑动窗口的最大值 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] aa = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = s.maxSlidingWindow(aa, 3);
        System.out.println(Arrays.toString(ints));
    }

    static class Solution {

        //单调栈；维护一个从大到小的双端栈，数据从右边进入，最大值从左边出！！！
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k < 1 || nums.length < k) return new int[]{};
            int[] result = new int[nums.length - k +1];
            //双端队列
            int index = 0;
            LinkedList<Integer> dqueue = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!dqueue.isEmpty()&&nums[dqueue.peekLast()]<=nums[i]){
                    dqueue.pollLast();
                }
                dqueue.addLast(i);
                if (dqueue.peekFirst() == i-k){
                    dqueue.pollFirst();
                }
                if (i>=k-1){
                    result[index++] = nums[dqueue.peekFirst()];
                }

            }
            return result;
        }
    }
}
