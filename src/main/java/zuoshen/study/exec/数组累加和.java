package zuoshen.study.exec;

/**
 * @author : 刘剑
 * @date : 2021/2/24 7:48 下午
 * @description
 */
public class 数组累加和 {

    /***
     * 一、给定一个正整数组成的无序数组arr，给定一个正整数值K
     * 找到arr的所有子数组里，哪个子数组的累加和等于K，并且是长度最大的
     * 返回其长度
     *
     * 二、给定一个整数组成的无序数组arr，值可能正、可能负、可能0
     * 给定一个整数值K
     * 找到arr的所有子数组里，哪个子数组的累加和等于K，并且是长度最大的
     * 返回其长度
     *
     * 三、给定一个整数组成的无序数组arr，值可能正、可能负、可能0
     * 给定一个整数值K
     * 找到arr的所有子数组里，哪个子数组的累加和<=K，并且是长度最大的
     * 返回其长度
     *
     * 总结：
     *
     * 题目一主要技巧：利用单调性优化
     *
     * 题目二主要技巧：利用预处理结构优化
     *
     * 题目三主要技巧：假设答案法+淘汰可能性（很难，以后还会见到）
     */

//===============================================================

    /***
     *  一、给定一个正整数组成的无序数组arr，给定一个正整数值K
     *      * 找到arr的所有子数组里，哪个子数组的累加和等于K，并且是长度最大的
     *      * 返回其长度
     * @param arr
     * @param K
     * @return
     *
     * todo 思路：滑动窗口
     */
    public static int getMaxLength(int[] arr, int K) {
        int left = 0, right = 0;
        //注意
        int sum = arr[0];
        int len = 0;
        while (right < arr.length){
            if (sum == K){
                len = Math.max(len,right - left +1);
                //移动左边，更新sum
                sum-=arr[left++];

            }else if (sum < K){
                right++;
                if (right == arr.length)break;
                sum+=arr[right];
            }else {
                sum-=arr[left++];
            }
        }
        return len;
    }
}
