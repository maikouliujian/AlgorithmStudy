package xiaomage._第三季_.shuati;

/**
 * @author lj
 * @createDate 2020/5/25 14:08
 **/
public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
//        Solution s = new Solution();
//        int [] nums1 = {-2};
//        int [] nums2 = {-5,4,5,9,100};

        int [] nums1 = {1,3,5};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftLen = nums1.length;
        int rightLen = nums2.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int left = 0;
        int right = 0;
        int len = leftLen + rightLen;
        //本意找到合并数组的中间值，从逻辑上进行合并
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if (leftIndex < leftLen && ( rightIndex >= rightLen || nums1[leftIndex] < nums2[rightIndex])){
                right = nums1[leftIndex++];
            }else {
                right = nums2[rightIndex++];
            }
        }

        if ((len & 1) == 0){
            return (left + right)/2.0;

        }else {
            return right;
        }


    }
}
