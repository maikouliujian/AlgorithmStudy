package xiaomage.shuati;

public class _11_盛最多水的容器 {


    //TODO 双指针问题，  向内走只能取大的值
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right){
            int len  = right -left;
            //谁小谁向里面移动
            //int hei = height[left]>height[right]?height[left]:height[right];
            int hei = Math.min(height[left],height[right]);
            max = Math.max(max,hei*len);
            if (hei == height[left]){
                left++;
            }else {
                right--;
            }

        }
        return max;
    }



    public int maxArea1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right){
//            int len  = right -left;
//            //谁小谁向里面移动
//            //int hei = height[left]>height[right]?height[left]:height[right];
//            int hei = Math.min(height[left],height[right]);
//            max = Math.max(max,hei*len);
//            if (hei == height[left]){
//                left++;
//            }else {
//                right--;
//            }
            int len  = right -left;
            if (height[left] < height[right]){
                max = Math.max(max,height[left]*len);
                left++;
            }else {
                max = Math.max(max,height[right]*len);
                right--;
            }
        }
        return max;
    }


    //TODO 优化点====>在移动过程中，若发现将要移动的位置，比移动之前的要小，则可以选择直接跳过！！！！！！
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right){
            int len  = right -left;
            if (height[left] < height[right]){
                int min = height[left];
                max = Math.max(max,height[left]*len);
                //TODO :在移动过程中，遇到比之前更小的，直接跳过
                while (left < right && height[left]<= min)left++;
            }else {
                int min = height[right];
                max = Math.max(max,height[right]*len);
                //TODO :在移动过程中，遇到比之前更小的，直接跳过
                while (left < right && height[right]<= min)right--;
            }
        }
        return max;
    }
}
