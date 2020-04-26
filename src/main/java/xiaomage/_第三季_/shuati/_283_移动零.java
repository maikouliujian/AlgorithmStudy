package xiaomage._第三季_.shuati;

public class _283_移动零 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int cur = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
                nums[cur++] = nums[i];
            }
        }
        //补0
        while (cur<len){
            nums[cur++] = 0;
        }

    }
}
