package zuoshen.topinterview.leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3108 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
    //todo 思路：双指针
//    public static List<List<Integer>> threeSum_bak(int[] nums) {
//        if (nums == null || nums.length == 0)return new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//        int left = 0;
//        int right = nums.length -1;
//        while (left <= right){
//            int cur = left+1;
//            while (cur < right){
//                if (nums[left]+nums[right] == - nums[cur]){
//                    result.add(Arrays.asList(nums[left],nums[cur],nums[right]));
//                }
//                cur++;
//            }
//            //todo 不能同时缩紧，会错过结果，只能一边靠近
//            left++;
//            //right--;
//        }
//        return result;
//
//    }


    //todo 思路：
    //1、先对整个数组排序
    //2、固定住第一个元素，从剩余的找其他两个（注意去重）
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0)return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //i为第一个元素的索引，至少为右边留两个元素
        for (int i = 0; i < nums.length-2; i++) {
            //todo 去重：如果左边元素出现相同元素，则结果会重复，所以需要去重，把相同元素跳过，相同元素只取一个；
            if (i>0 && nums[i-1] == nums[i])continue;
            int left = i+1;
            int right = nums.length -1;
            while (left < right){
                int sum = nums[i] + nums[left]+nums[right];
                if (sum == 0){
                    //todo 跳过重复的
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&& nums[left]==nums[left+1])left++;
                    while (left<right&& nums[right]==nums[right-1])right--;

                    //找到相等的，得同时移动，不然找出来是重复的；
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
