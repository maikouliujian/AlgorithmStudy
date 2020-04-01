package xiaomage._第三季_.栈_队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class good_239_滑动窗口最大值 {

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = new good_239_滑动窗口最大值().maxSlidingWindow(nums, 3);
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
}
