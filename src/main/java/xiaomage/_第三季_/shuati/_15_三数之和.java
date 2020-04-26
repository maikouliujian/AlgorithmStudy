package xiaomage._第三季_.shuati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public static void main(String[] args) {
        //List<List<Integer>> lists = new _15_三数之和().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> lists = new _15_三数之和().threeSum(new int[]{-2,0,0,2,2});
        System.out.println(lists);
    }


    /***
     * TODO : 思路====>1、先对数组进行排序
     *                 2、固定一定元素i，从元素i+1,到nums.length -1 范围寻找满足条件的元素
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        //排序
        Arrays.sort(nums);
        //遍历
        for (int i = 0; i < nums.length-2; i++) {
            int left = i +1;
            int right = nums.length-1;

            //TODO 去重 当前元素与上个元素相等，跳过！！！
            if (i>0 &&nums[i] == nums[i-1])continue;

            while (left < right){
                //找到结果
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0){
                    result.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    //找到结果移动指针
                    //TODO
                    while (left<right&&nums[left+1] == nums[left])left++;
                    while (left<right&&nums[right-1] == nums[right])right--;

                    left++;
                    right--;
                }else if (sum>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
