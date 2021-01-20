package suanfa.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author : 刘剑
 * @date : 2021/1/7 4:42 下午
 * @description
 *
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4;
 * 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
 * todo 保证栈单调递增！！！
 *
 */
public class _单调栈 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] ints = s.singleStack(new int[]{2, 1, 2, 4, 3});
        System.out.println(Arrays.toString(ints));

    }

    static class Solution {

        public int[] singleStack(int[] arr) {
            if (arr  == null || arr.length == 0)return new int[]{};
            //倒序遍历，正序出栈
            int[] res = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = arr.length-1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek()<= arr[i]){
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1:stack.peek();
                stack.push(arr[i]);

            }

            return res;

        }
    }


}
