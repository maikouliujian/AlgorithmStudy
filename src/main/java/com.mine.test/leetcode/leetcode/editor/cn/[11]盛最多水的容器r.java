package com.mine.test.leetcode.leetcode.editor.cn;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {
    //todo 思路：求面积，双指针问题
    public int maxArea(int[] height) {
        if (height == null|| height.length ==1)return 0;
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while (left < right){
            int len = right - left;
            int min = Math.min(height[left], height[right]);
            max = Math.max(max,len * min);
            //那边小，那边锁进
            if (min == height[left]){
                left++;
            }else {
                right--;
            }

        }
        return max;

    }

    public static void main(String[] args) {
        int i = maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }


    //todo 思路：求面积，双指针问题
    public static int maxArea1(int[] height) {
        if (height == null|| height.length ==1)return 0;
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while (left < right){
            int len = right - left;
            int min = Math.min(height[left], height[right]);
            max = Math.max(max,len * min);
            //那边小，那边锁进
            //todo 优化点，如果缩紧过程中遇到更小的，则可以继续锁进，因为我们是要找更大，更小的可以跳过
            if (min == height[left]){
                //left++;
                while (left < right && height[left] <= min){
                    left++;
                }
            }else {
                //right--;
                while (left < right && height[right] <= min){
                    right--;
                }
            }

        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
