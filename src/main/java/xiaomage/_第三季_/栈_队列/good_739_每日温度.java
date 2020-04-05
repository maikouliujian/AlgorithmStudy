package xiaomage._第三季_.栈_队列;

import java.util.Arrays;
import java.util.Stack;

public class good_739_每日温度 {
    /***
     * 题意解析：寻找每个元素右边第一个比其大的元素
     * TODO : 使用单调递减栈
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        //维护两个索引，分别存放i对应的左、右边第一个比它大的值的索引
        //int lindexs[] = new int[nums.length];
        int rindexs[] = new int[T.length];
        int result[] = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            rindexs[i] = -1;
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                rindexs[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < rindexs.length; i++) {
            result[i] = rindexs[i]<0?0: rindexs[i]- i;
        }
        return result;

    }


    public int[] dailyTemperatures1(int[] T) {
        Stack<Integer> stack = new Stack<>();
        //维护两个索引，分别存放i对应的左、右边第一个比它大的值的索引
        //int lindexs[] = new int[nums.length];
        //int rindexs[] = new int[T.length];
        int result[] = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            //rindexs[i] = -1;
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

//        for (int i = 0; i < rindexs.length; i++) {
//            result[i] = rindexs[i]<0?0: rindexs[i]- i;
//        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = new  int[]{73, 74, 75, 71, 69, 72, 76, 73};
        //int arr[] = new  int[]{73,74,75,71,69,72,76,73};
        new good_739_每日温度().dailyTemperatures2(arr);
    }


    /***
     * 倒推法
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        //初始化！！！
        result[T.length-1] = 0;
        for (int i = T.length -2; i >=0 ; i--) {
            int j = i +1;

           // while (j < T.length){
//            while (true){
//                if (T[i]<T[j]){
//                    result[i] = j-i;
//                    break;
//                }else if (T[i]==T[j]){
//                    if (result[j] == 0){
//                        result[i] =0;
//                        break;
//                    }
//                    result[i] = result[j]+j-i;
//                    break;
//                }else {
//                    if (result[j] == 0){
//                        result[i] =0;
//                        break;
//                    }
//                    j = result[j]+j;
//                }
//            }

            while (true){
                if (T[i]<T[j]){
                    result[i] = j-i;
                    break;
                }else if (result[j] == 0){
                    result[i] =0;
                    break;
                }else if (T[i]==T[j]){
                    result[i] = result[j]+j-i;
                    break;
                }else {
                    j = result[j]+j;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return result;

    }
}
