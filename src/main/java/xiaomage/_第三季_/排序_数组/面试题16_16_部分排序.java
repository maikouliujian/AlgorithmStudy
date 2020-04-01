package xiaomage._第三季_.排序_数组;

public class 面试题16_16_部分排序{

    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1,-1};
        //if (array.length == 1) return new int[]{-1,-1};

//        for (int i = 0; i <array.length; i++) {
//            if (array[i] >=max){
//                max = array[i];
//            }else {
//                index1 = i;
//            }
//
//        }
        //放两个指针，扫描一遍；
//        int max = Integer.MIN_VALUE;
//        int index1 = 0;
//        int result1 = index1;
//        int min = Integer.MAX_VALUE;
//        int index  = array.length -1;
//        int index2 = index;
//        int result2 = index2;
//
//        while (index1 <= index || index2 >= 0){
//            if (array[index1] >=max){
//                max = array[index1++];
//            }else {
//                result1=index1++;
//            }
//
//            if (array[index2] <=min){
//                min = array[index2--];
//            }else {
//                result2=index2--;
//            }
//        }
//
//        return new int[]{result2,result1};

        //重新写！！！
        //从左向右找到比最大值小的索引
        int max = array[0];
        int r = -1;
        for (int i = 1; i <array.length; i++) {
            if (array[i] >=max){
                max = array[i];
            }else {
                r = i;
            }

        }

        if (r == -1) return new int[]{-1,-1};

        int min = array[array.length-1];
        int l = -1;
        for (int i = array.length-2; i >=0 ; i--) {
            if (array[i] <=min){
                min = array[i];
            }else {
                l = i;
            }
        }

        // n + n
        return new int[]{l,r};



    }


}
