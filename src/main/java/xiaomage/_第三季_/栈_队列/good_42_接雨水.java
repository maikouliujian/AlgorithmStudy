package xiaomage._第三季_.栈_队列;

import java.util.Arrays;
import java.util.Stack;

/***
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * todo : 思路1：一列一列的求=====>该题目可以转化为求每个元素左、右边 最大的值，二者中最小的；
 * TODO :最小值减去当前值，就是该列可以存储的雨水数
 */
public class good_42_接雨水 {

    public static void main(String[] args) {
        int nums [] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        new good_42_接雨水().trap2(nums);
    }


    /***
     * 思路1：找出每一列左边和右边最大值，取二者中最小值，如果当前列比二者中最小值还大，则可以存储雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length-1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }


        }
        return sum;

    }

    /***
     * 在上面方法的基础上进行dp优化！！！
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        //首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }



    /***
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     * 思路： 使用栈！！！！！！！！！！！！！！！！！
     *
     * 说到栈，我们肯定会想到括号匹配了。我们仔细观察蓝色的部分，可以和括号匹配类比下。每次匹配出一对括号（找到对应的一堵墙），就计算这两堵墙中的水。

     我们用栈保存每堵墙。

     当遍历墙的高度的时候，如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。

     如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。



     *
     * 而对于计算 current 指向墙和新的栈顶之间的水，根据图的关系，
     * 我们可以直接把这两个墙当做之前解法三的 max_left 和 max_right，
     * 然后之前弹出的栈顶当做每次遍历的 height [ i ]。
     * 水量就是 Min ( max _ left ，max _ right ) - height [ i ]，只不过这里需要乘上两个墙之间的距离。可以看下代码继续理解下。

     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素(墙底部)
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去====>没有左边的墙，跳出
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);  //【两堵墙的最小值减去墙底部】
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }



    public int trap2_mine_copy(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                //取出两堵墙底部
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) break;
                //计算两堵墙的距离
                int distance = i - stack.peek() -1;
                //计算两堵墙的最小值
                int min  = Math.min(height[stack.peek()],height[i]);
                //计算两堵墙之间的面积
                sum += distance * (min - h);
            }
            stack.push(i);
        }
        return sum;
    }

}
