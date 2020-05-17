package xiaomage._第三季_.shuati;

public class _42_接雨水 {


    //TODO 思路：求每一个主子可以承接的水量
    //todo 求出每个柱子  左边最大的柱子和右边最大的柱子，取二者最小值，然后减去自身高度，就是可以承接的水量
    public int trap(int[] height) {
        if (height == null || height.length == 0)return 0;

        //分别求左右最大柱子
        int[] leftMax = new int[height.length];
        //定义leftMax[i]为i左边最大的柱子，则leftMax[i] = max(leftMax[i-1],height[i-1])
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        int[] rightMax = new int[height.length];
        for (int i = height.length-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }

        //计算雨水
        int water = 0;
        for (int i = 1; i < height.length-1; i++) {
            int min = Math.min(leftMax[i],rightMax[i]);
            //排除不能放水的情况
            if (min <= height[i])continue;
             water+=min-height[i];
        }
        return water;


    }
}
