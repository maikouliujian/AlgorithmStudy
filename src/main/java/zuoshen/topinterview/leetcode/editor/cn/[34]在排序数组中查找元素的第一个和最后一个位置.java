package zuoshen.topinterview.leetcode.editor.cn;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1054 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {

    public static void main(String[] args) {
        int arr[] = new int[]{5,7,7,8,8,10};
        int[] ints = new Solution34().searchRange(arr, 6);
        System.out.println(Arrays.toString(ints));
    }
    //todo 二分查找
    //1、使用二分查找寻找 小于等于target的最大值，大于等于target的最小值；
    public int[] searchRange(int[] nums, int target) {
         if (nums.length == 0)return new int[]{-1,-1};
         int left = findfirst(nums,target);
         int right = findright(nums,target);
         return new int[]{left,right};
    }

    /***
     * 小于等于target的最大值
     * @param nums
     * @param target
     * @return
     */
    private int findRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int result = -1;
        while (l<= r){
            int m = l + ((r -l)>>1);
            if (nums[m] <= target){
                result = m;
                l= m+1;
            }else {
                r = m-1;
            }
        }
        return result;
    }

    /***
     * 大于等于target的最小值
     * @param nums
     * @param target
     * @return
     */
    private int findLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int result = -1;
        while (l<= r){
            int m = l + ((r -l)>>1);
            if (nums[m] >= target){
                result = m;
                r = m-1;
            }else {
                l = m+1;
            }
        }
        return result;
    }


    private int findfirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int result = -1;
        int m  = 0;
        while (l<= r){
            m = l + ((r -l)>>1);
            if (nums[m] > target){
                r = m-1;
            }else if (nums[m] < target){
                l = m+1;
            }else {
                result = m;
                r = m-1;
            }

        }
        return result;
    }


    private int findright(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int result = -1;
        while (l<= r){
            int m = l + ((r -l)>>1);
            if (nums[m] < target){
                l= m+1;
            }else if (nums[m] > target){
                r = m-1;
            }else {
                result = m;
                l= m+1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
