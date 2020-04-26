package xiaomage._第三季_.dfs;

import java.util.ArrayList;
import java.util.List;

public class good_47_全排列II {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        dfs(0,nums,result);

        return result;

    }

    private void dfs(int idx, int[] nums, List<List<Integer>> result) {
        if (idx == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            //遍历到i时，如果i之前出现过相等的数，就跳过交换
            //if (nums[i] == nums[idx]) continue;
            if(isReaped(idx, nums, i))continue;
            swap(i,idx,nums);
            dfs(idx+1,nums,result);
            swap(i,idx,nums);
        }
    }

    private boolean isReaped(int idx, int[] nums, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
