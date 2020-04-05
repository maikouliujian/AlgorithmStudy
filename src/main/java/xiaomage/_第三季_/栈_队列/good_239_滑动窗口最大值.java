package xiaomage._第三季_.栈_队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class good_239_滑动窗口最大值 {

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = new good_239_滑动窗口最大值().maxSlidingWindow2(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    //思路1：采用双端队列

    /***
     * 1.如果nums[i] >= nums[队尾]，不断删除队尾，直到nums[队尾]>nums[i]为止
     * 2.将i加入队尾
     * 3.如果w>=0
     *  (1)如果队头失效，就移除队头（如果队头<w就代表失败）
     *  (2)设置w窗口的最大值为nums[队头]
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <=0) return nums;
        if (k == 1) return nums;
        //先计算结果数组的大小  nums.length -k +1
        int[] result = new int[nums.length -k +1];
        //双队列,里面存放的是索引
        Deque<Integer> deque = new LinkedList<>();
        //窗口的首尾元素
        int win_start = -k+1;
        int win_end = 0;
        for (win_end = 0; win_end < nums.length; win_end++) {
            //判断nums[i]和队列尾元素的大小，移除比nums【i】小的元素
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[win_end]){
                deque.removeLast();  //o(1)
            }
            //加入队尾
            deque.addLast(win_end);
            //判断win_start是否为非法索引
            if (win_start< 0){
                //pass
                win_start++;
            }else {
                //判断队头索引是否在窗口中
                Integer peek = deque.peek();
                while (!(win_start<= peek && peek <= win_end)){
                    deque.pollFirst();
                }
                //加入结果
                result[win_start++] = nums[deque.peekFirst()];
            }

        }

        return result;


    }



    public int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <=0) return nums;
        if (k == 1) return nums;
        //先计算结果数组的大小  nums.length -k +1
        int[] result = new int[nums.length -k +1];
        //双队列,里面存放的是索引
        Deque<Integer> deque = new LinkedList<>();
        //窗口的首尾元素
        //TODO:改进：win_start可以根据win_end求得，不需要自己维护！！！
        //int win_start = -k+1;
        //int win_end = 0;
        for (int win_end = 0; win_end < nums.length; win_end++) {
            //判断nums[i]和队列尾元素的大小，移除比nums【i】小的元素
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[win_end]){
                deque.removeLast();  //o(1)
            }
            //加入队尾
            deque.addLast(win_end);

            int win_start = win_end - k +1;
            //判断win_start是否为非法索引
            if (win_start < 0) continue;
            //判断队头索引是否在窗口中
//            Integer peek = deque.peek();
//            while (!(win_start<= peek && peek <= win_end)){
//                deque.pollFirst();
//            }
            //TODO :关于合法性的校验：最多只会有一个元素不合法[小于窗口头]
            if (deque.peekFirst() < win_start) deque.removeFirst();
            //while (deque.peekFirst() < win_end) deque.removeFirst();
            //加入结果
            result[win_start] = nums[deque.peekFirst()];

//            if (win_start< 0){
//                //pass
//                win_start++;
//            }else {
//                //判断队头索引是否在窗口中
//                Integer peek = deque.peek();
//                while (!(win_start<= peek && peek <= win_end)){
//                    deque.pollFirst();
//                }
//                //加入结果
//                result[win_start++] = nums[deque.peekFirst()];
//            }

        }

        return result;


    }


    /***
     * 思路：采用一个临时变量存储最大值索引
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <=0) return nums;
        if (k == 1) return nums;
        //先计算结果数组的大小  nums.length -k +1
        int[] result = new int[nums.length -k +1];
        int max_index = -1;
        for (int win_start = 0; win_start < result.length; win_start++) {
            int win_end = win_start+k-1 > nums.length-1?nums.length-1:win_start+k-1;

            //遍历窗口内的元素，取最大值
            //TODO :优化点,如果max_index == -1或者max_index过期，重新遍历窗口；否则只需要比较新入窗口的值和最大值
            if (max_index == -1 || max_index < win_start){
                //int max_value = max_index<0?nums[win_start]:nums[max_index];
                int max_value = nums[win_start];
                for (int i = win_start; i <= win_end; i++) {
                    if (nums[i] >= max_value){
                        max_index = i;
                        max_value = nums[max_index];
                    }
                }
            }else {
                max_index = nums[max_index] > nums[win_end] ? max_index:win_end;
            }
            result[win_start] = nums[max_index];

        }

        return result;


    }


    public int[] maxSlidingWindow3(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <=0) return nums;
        if (k == 1) return nums;
        //先计算结果数组的大小  nums.length -k +1
        int[] result = new int[nums.length -k +1];
        int max_index = -1;
        for (int win_start = 0; win_start < result.length; win_start++) {
            int win_end = win_start+k-1 > nums.length-1?nums.length-1:win_start+k-1;

            //遍历窗口内的元素，取最大值
            //TODO :优化点,如果max_index == -1或者max_index过期，重新遍历窗口；否则只需要比较新入窗口的值和最大值
            if (max_index == -1 || max_index < win_start){
                //todo :两种判断！！！
                if (max_index == -1){
                    max_index = 0;
                }
                if (max_index < win_start){
                    max_index = win_start;
                }
                for (int i = win_start; i <= win_end; i++) {
                    if (nums[i] >= nums[max_index]){
                        max_index = i;
                    }
                }
            }else {
                //max_index = nums[max_index] > nums[win_end] ? max_index:win_end;
                if (nums[win_end] >= nums[max_index]) max_index = win_end;
            }
            result[win_start] = nums[max_index];

        }

        return result;


    }



    public int[] maxSlidingWindow4(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <=0) return nums;
        if (k == 1) return nums;
        //先计算结果数组的大小  nums.length -k +1
        int[] result = new int[nums.length -k +1];
        //初始化最大索引为0
        int max_index = 0;
        //为了将上述的两种判断区分开，先进行一次第一个窗口的扫描；
        for (int i = 1; i<k; i++) {
            if (nums[i] >= nums[max_index]) max_index = i;
        }

        //开始滑动窗口
        for (int win_start = 0; win_start < result.length; win_start++) {
            //int win_end = win_start+k-1 > nums.length-1?nums.length-1:win_start+k-1;
            int win_end = win_start+k-1 ;

            //遍历窗口内的元素，取最大值
            if (max_index < win_start){
                //TODO :max_index失效，重置max_index
                max_index = win_start;
                for (int i = win_start+1; i <= win_end; i++) {
                    if (nums[i] >= nums[max_index]){
                        max_index = i;
                    }
                }
            }else if (nums[win_end] >= nums[max_index]){
                //max_index = nums[max_index] > nums[win_end] ? max_index:win_end;
                max_index = win_end;
            }
            result[win_start] = nums[max_index];

        }

        return result;


    }
}
