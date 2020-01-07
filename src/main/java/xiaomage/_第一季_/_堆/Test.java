package xiaomage._第一季_._堆;

import xiaomage.printer.BinaryTrees;

/**
 * @author lj
 * @createDate 2020/1/7 11:51
 **/
public class Test {

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(5);
        heap.add(10);
        heap.add(1);
        heap.add(7);
        heap.add(2);
        heap.add(10);

        BinaryTrees.println(heap);

        heap.remove();
        heap.remove();
        heap.remove();
        BinaryTrees.println(heap);
    }
}
