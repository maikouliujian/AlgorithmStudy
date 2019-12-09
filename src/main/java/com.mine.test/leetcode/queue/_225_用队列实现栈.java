package com.mine.test.leetcode.queue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lj
 * @createDate 2019/11/29 17:35
 **/
public class _225_用队列实现栈 {

    /***
     使用队列实现栈的下列操作：

     push(x) -- 元素 x 入栈
     pop() -- 移除栈顶元素
     top() -- 获取栈顶元素
     empty() -- 返回栈是否为空

     注意:

     你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/implement-stack-using-queues
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class MyStack {

        //https://leetcode-cn.com/problems/implement-stack-using-queues/solution/java-queue-shi-xian-54-ms-34-mb-by-onlya/
        //引入top指针
        private int top;

        /**
         * Initialize your data structure here.
         */
        //使用两个队列
        Queue<Integer> one;
        Queue<Integer> two;

        public MyStack() {
            one = new LinkedList<Integer>();
            two = new LinkedList<Integer>();

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            top = x;
            //压入不为空的队列
            if (!one.isEmpty()) {
                one.offer(x);
                return;
            }
            if (!two.isEmpty()) {
                two.offer(x);
                return;
            }
            if (empty()) {
                one.offer(x);
            }


        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            //先将不为空的队列元素放入全部为空的元素中，只留最后一个
            if (one.isEmpty() && two.isEmpty()) return -1;
            Queue<Integer> in;
            Queue<Integer> out;
            if (!one.isEmpty() && two.isEmpty()) {
                out = one;
                in = two;
            } else {
                out = two;
                in = one;
            }
            while (out.size() > 1) {
                in.offer(out.poll());
            }
            int result = out.poll();
            return result;

        }

        /**
         * Get the top element.
         */
        public int top() {

            //先将不为空的队列元素放入全部为空的元素中，只留最后一个
            if(one.isEmpty() && two.isEmpty()) return -1;
            Queue<Integer> in;
            Queue<Integer> out;
            if (!one.isEmpty() && two.isEmpty()){
                out = one;
                in = two;
            }else {
                out = two;
                in = one;
            }
            while (out.size() > 1){
                in.offer(out.poll());
            }
            int result = out.peek();
            //TODO 注意这一步很关键！！！
            in.offer(out.poll());
            return result;

        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return one.isEmpty() && two.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


    class TwoMyStack {
        //队列
        Queue queue;
        //直接保存栈顶元素
        int top;
        /** Initialize your data structure here. */
        public TwoMyStack() {
            //LinkedList实现了Queue接口，所以可以把LinkedList当作一个队列来使用
            queue = new LinkedList();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            //更新栈顶元素
            top = x;
            //将栈顶元素加入到队列尾
            queue.offer(top);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            //使用一个临时队列来更新
            Queue temp = new LinkedList();
            //因为要返回弹出的元素，所以事先保存下来
            int oldTop = top;
            int size = queue.size();
            //循环更新每个元素，执行到最后时栈顶元素也更新了
            for(int i = 0; i < size -1 ; i++){
                top = (int) queue.remove();
                temp.offer(top);
            }
            //更新队列（栈）
            queue = temp;
            return oldTop;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.size() == 0 ? true : false;
        }
    }

}
