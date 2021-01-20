package suanfa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lj
 * @createDate 2019/7/31 16:58
 **/
public class q15_三数之和 {
    /***
     给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

     注意：答案中不可以包含重复的三元组。

     例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

     满足要求的三元组集合为：
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/3sum
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) return result;
            int len = nums.length;
            //对数组排序
            Arrays.sort(nums);
            //一次遍历
            for (int i = 0; i < len; i++) {
                //如果大于0；之和肯定不会为0
                if (nums[i] > 0) break;
                //去重 i-1已经计算过，i就不需要再计算了
                if (i > 0 && nums[i] == nums[i-1]) continue;

                //定义双指针
                int l = i +1;
                int r = len -1;

                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0){
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        //去重
                        while (l<r && nums[l] == nums[l+1]) l++; // 去重
                        while (l<r && nums[r] == nums[r-1]) r--; // 去重
                        l++;
                        r--;
                    }else if (sum <0 ){
                        l++;
                    }else if (sum > 0){
                        r--;
                    }
                }


            }

            return result;

        }
    }

}
