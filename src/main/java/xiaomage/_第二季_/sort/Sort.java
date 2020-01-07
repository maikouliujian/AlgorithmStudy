package xiaomage._第二季_.sort;

import java.util.Arrays;

/**
 * @author lj
 * @createDate 2020/1/6 18:44
 **/
public class Sort {
    public static void main(String[] args) {
        int[] src = {9,6,2,344,1,41,7};
        // bubblingSort(src);
        insertSort(src);
        System.out.println(Arrays.toString(src));
    }


    /***
     * 冒泡排序
     * @param src
     */
    public static void bubblingSort(int[] src){
        for (int i = 0; i < src.length -1; i++) {
            for (int j = 0; j < src.length - 1-i; j++) {
                if (src[j] > src[j +1]){
                    swap(j,j+1,src);
                }
            }
        }
    }


    /***
     * 冒泡排序1
     * @param src
     */
    public static void bubblingSort1(int[] src){
        for (int i = src.length -1; i >0 ; i--) {
            for (int j = 1; j <=i ; j++) {
                if (src[j-1] > src[j]){
                    swap(j,j-1,src);
                }
            }
        }
    }

    /***
     * 冒泡排序 :优化1：如果数组有序，则不需要再遍历
     * @param src
     */
    public static void bubblingSort2(int[] src){
        for (int i = src.length -1; i >0 ; i--) {
            boolean sorted = true;
            for (int j = 1; j <=i ; j++) {
                if (src[j-1] > src[j]){
                    swap(j,j-1,src);

                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }


    /***
     * 冒泡排序 :优化2：尾部局部有序，记录最后一次交换的位置
     * @param src
     */
    public static void bubblingSort3(int[] src){
        for (int i = src.length -1; i >0 ; i--) {
            //TODO 为完全有序做跳出判断；
            int sortedIndex = 1;
            for (int j = 1; j <=i ; j++) {
                if (src[j-1] > src[j]){
                    swap(j,j-1,src);
                    //记录最后一次交换的位置
                    sortedIndex = j;
                }
            }
            i = sortedIndex;
        }
    }




    /***
     * 选择排序
     * @param src
     */
    public static void selectSort(int[] src){
        for (int i = 0; i < src.length -1; i++) {
            for (int j = i +1; j < src.length; j++) {
                if (src[i] > src[j]){
                    swap(j,i,src);
                }
            }
        }
    }


    /***
     * 选择排序  每次取出除最后一个元素中的最大值，然后让其和最后一个值互换，先固定最大值
     * @param src
     */
    public static void selectSort1(int[] src){
        for (int end = src.length -1; end > 0  ; end--) {
            //默认第一个值为最大值；
            int maxIndex = 0;
            for (int j = 1; j <= end; j++) {
                //取出所有值中最大值
                if (src[maxIndex] <= src[j]){
                    maxIndex = j;
                }
            }
            swap(maxIndex,end,src);
        }
    }

    private static void swap(int j, int i, int[] src) {
        int tmp = src[j];
        src[j] = src[i];
        src[i] = tmp;
    }


    /***
     * 堆排序 分两步
     * 1、原地建堆
     * 2、交换堆顶和堆底元素
     */
    public static void heapSort(int[] src){
        int heapSize = src.length;
        for (int i = (heapSize>>1)-1; i >=0 ; i--) {
            shiftDown(i,src);
        }

        while (heapSize >1){
            swap(0,--heapSize,src);
            shiftDown(0,src);
        }

    }

    private static void shiftDown(int index,int[] elements) {
        //保证index是非叶子节点
        //index小于第一个叶子节点的索引
        int size = elements.length;
        int half = size >>1;
        int element = elements[index];
        while (index < half){
            //非叶子节点1、只有左子节点，2、同时有左右子节点
            int childIndex = (index <<1)+1;
            int child = elements[childIndex];

            //比较右子节点
            int rightChild = childIndex +1;
            int right = elements[rightChild];
            if (rightChild < size && child<right){
                child = right;
                childIndex = rightChild;
            }
            if (element> child)break;
            elements[index] = child;
            index = childIndex;
        }

        elements[index] = element;

    }



    /***
     * 插入排序
     */
    public static void insertSort(int[] src){
        //插入排序是从第一个元素开始的

        for (int i = 1; i < src.length ; i++) {
            int tmp = src[i];
            int j = i;
            while (j > 0 && src[j-1] > tmp){
                src[j] = src[j-1];
                j--;
            }
            src[j] = tmp;
        }

    }


    /***
     * 插入排序的优化
     * 利用二分查找法
     */
    public static void insertSort1(int[] src){
        //插入排序是从第一个元素开始的

        for (int i = 1; i < src.length ; i++) {
            int tmp = src[i];
            int j = i;
            while (j > 0 && src[j-1] > tmp){
                src[j] = src[j-1];
                j--;
            }
            src[j] = tmp;
        }

    }
}
