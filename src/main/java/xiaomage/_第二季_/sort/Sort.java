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
        selectSort(src);
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
