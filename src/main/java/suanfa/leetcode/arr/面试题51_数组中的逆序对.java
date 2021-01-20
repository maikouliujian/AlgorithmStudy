package suanfa.leetcode.arr;

/**
 * @author lj
 * @createDate 2020/4/24 9:39
 **/
public class 面试题51_数组中的逆序对 {

    int result = 0;


    //TODO :  思路：归并排序取逆序
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        merge(nums, 0, nums.length - 1);
        return result;

    }


    private void merge(int[] nums, int left, int right) {
        //先拆后合并 === >采用递归拆分,拆分到相等为止
        if (left >= right) return;
        int middle = left + ((right - left) >> 1);
        merge(nums, left, middle);
        merge(nums, middle + 1, right);
        merge_sort(nums, left, middle, right);
    }

    //合并逻辑
    private void merge_sort(int[] nums, int left, int middle, int right) {
        //辅助空间！！！
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0; //辅助指针

        while (i <= middle && j <= right) {
            //前一半有序和后一半有序进行对比！！！
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                // 则从 nums[i] 到 nums[middle] 必定都是大于 nums[j] 的，
                // 因为两部分的子数组已经是各自有序的

                //todo : 算法核心部分！！！！！！
                result += (middle - i + 1);
            }
        }


        //补充剩余
        while (i <= middle) {
            tmp[k++] = nums[i++];
        }


        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        //还原现场！！！！
        for (int l = 0; l < k; l++) {
            nums[left + l] = tmp[l];
        }
    }
}
