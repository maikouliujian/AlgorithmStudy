package suanfa.leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q1_两数之和 {
    /***
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {



    }

    public static void print(ListNode root){
        ListNode cur = root;
        while (cur!= null){
            System.out.print(cur.val + "--->");
            cur = cur.next;

        }
    }


    static class Solution {

        public int[] twoSum(int[] nums, int target) {
//            Map<Integer,Integer> tmp = new HashMap<Integer, Integer>();
//            int[] result = new int[2];
//            for (int i = 0; i < nums.length; i++) {
//                int other = target - nums[i];
//                if (tmp.containsKey(other)){
//                    result[0] = tmp.get(other);
//                    result[1] = i;
//
//                }else {
//                    tmp.put(nums[i],i);
//                }
//            }
//            return result;

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])){
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;

        }

    }

}
