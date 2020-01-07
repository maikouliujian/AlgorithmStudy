package xiaomage._第一季_._堆;

import xiaomage.printer.BinaryTreeInfo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 二叉堆的实现
 * @author lj
 * @createDate 2020/1/7 10:26
 **/
public class BinaryHeap<E> implements Heap<E>, BinaryTreeInfo {
    private E[] elements;
    private int size;
    private Comparator<E> comparator;

    private static final int DEFAULT_CAPACITY = 10;


    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }


    public BinaryHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;

    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        //2、扩容，先跳过
        //3、将元素添加到最后一位；
        elements[size++] = element;
        //TODO 进行上浮操作！！！
        shiftUp(size-1);
    }

    private void shiftUp(int index) {
        //把index当作childIndex
        E element = elements[index];
        while (index > 0 ){
            int parentIndex =  (index -1) >> 1;
            if (compare(element,elements[parentIndex])<= 0) break;
            //交换元素
            elements[index] = elements[parentIndex];
            index = parentIndex;
        }
        //跳出循环，交换元素
        elements[index] = element;

    }

    @Override
    public E get() {
        //获取堆顶元素
        emptyCheck();
        return elements[0];
    }

    private void emptyCheck(){
        if (size == 0)
            throw new IndexOutOfBoundsException("heap is empty");
    }


    private void elementNotNullCheck(E element){
        if (element == null)
            throw new IllegalArgumentException("element is empty");
    }

    @Override
    public E remove() {
        emptyCheck();
        //删除堆顶元素
        //做法：1、将数组尾部元素覆盖堆顶元素
        //      2、删除数组尾部元素
        E root = elements[0];
        int lastIndex = --size;
        elements[0] = elements[lastIndex];
        elements[lastIndex]= null;
        //size--;
        shiftDown(0);
        return root;
    }

    private void shiftDown(int index) {
        //保证index是非叶子节点
        //index小于第一个叶子节点的索引
        int half = size >>1;
        E element = elements[index];
        while (index < half){
            //非叶子节点1、只有左子节点，2、同时有左右子节点
            int childIndex = (index <<1)+1;
            E child = elements[childIndex];

            //比较右子节点
            int rightChild = childIndex +1;
            E right = elements[rightChild];
            if (rightChild < size && compare(child,right) <=0){
                child = right;
                childIndex = rightChild;
            }
            if (compare(element,child) > 0)break;
            elements[index] = child;
            index = childIndex;
        }

        elements[index] = element;

    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0){
            elements[0] = element;
            size++;
        }else {
            root = elements[0];
            elements[0] = element;
            shiftDown(0);
        }
        return root;
    }


    private void heapify(){
        //TODO 堆化有两种方式：
        //TODO :1、自顶向下的上浮2、自底向上的下滤
//        for (int i = 0; i < size; i++) {
//            shiftUp(i);
//        }

        for (int i = (size >> 1) -1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private int compare(E e1,E e2){
        return comparator !=null ? comparator.compare(e1,e2) :
                ((Comparable<E>)e1).compareTo(e2);
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        Integer index = (Integer)node;
        index = (index <<1) +1;
        return index>=size ? null:index;
    }

    @Override
    public Object right(Object node) {
        Integer index = (Integer)node;
        index = (index <<1) +2;
        return index>=size ? null:index;
    }

    @Override
    public Object string(Object node) {
        Integer index = (Integer)node;
        return elements[index];
    }
}
