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
        bubblingSort3(src);
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

    private static void swap(int j, int i, int[] src) {
        int tmp = src[j];
        src[j] = src[i];
        src[i] = tmp;
    }
}
