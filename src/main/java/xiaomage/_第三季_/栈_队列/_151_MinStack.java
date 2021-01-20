package xiaomage._第三季_.栈_队列;


/***
 * 思路1：维护两个栈，一个维护正常数据，一个维护最小值
 * 思路2：使用链表来维护
 */
public class _151_MinStack {

//    Stack<Integer> stackData = null;
//    Stack<Integer> stackMin = null;
//
//    /** initialize your data structure here. */
//    public _151_MinStack() {
//        stackData = new Stack<>();
//        stackMin = new Stack<>();
//    }
//
//    public void push(int x) {
//        stackData.push(x);
//        if (stackMin.isEmpty()){
//            stackMin.push(x);
//        }else {
//            Integer min = stackMin.peek();
//            if (x >= min){
//                stackMin.push(min);
//            }else {
//                stackMin.push(x);
//            }
//        }
//    }
//
//    public void pop() {
//        stackData.pop();
//        stackMin.pop();
//    }
//
//    public int top() {
//        return stackData.peek();
//    }
//
//    public int getMin() {
//        return stackMin.peek();
//
//    }


    //=================================================================================//
    //记录头节点
    LNode head;

        /** initialize your data structure here. */
    public _151_MinStack() {
        //可以搞一个空的头节点
        //head = new LNode(0,Integer.MAX_VALUE,null);  这样在push时，就不需要判断  head == null
    }

    public void push(int x) {
        if (head == null){
            head = new LNode(x,x,null);
        }else {
            head = new LNode(x,Math.min(x,head.min),head);
        }

    }

    public void pop() {
        head = head.next;

    }

    public int top() {
        return head.data;

    }

    public int getMin() {
        return head.min;

    }

    static class LNode{
        int data;
        int min;
        LNode next;

        public LNode() {
        }

        public LNode(int data, int min, LNode next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }

        public LNode(int data) {
            this.data = data;
        }


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }
    }
}

