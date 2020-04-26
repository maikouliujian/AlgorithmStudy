package xiaomage._第三季_.shuati;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tmp  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//            if (tmp.size() == 0){
//                tmp.put(target - nums[i],i);
//            }else {
//                Integer index = tmp.getOrDefault(nums[i], -1);
//                if (-1 != index) return new int[]{index,i};
//                tmp.put(target-nums[i],i);

            Integer index = tmp.getOrDefault(nums[i], -1);
            if (-1 != index) return new int[]{index,i};
            tmp.put(target-nums[i],i);

        }
        return new int[]{-1,-1};

    }
}
