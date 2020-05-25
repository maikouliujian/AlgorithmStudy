package xiaomage.shuati;

import java.util.ArrayList;
import java.util.List;

public class 面试题62_圆圈中最后剩下的数字{
    public static void main(String[] args) {
        int i = new 面试题62_圆圈中最后剩下的数字().lastRemaining(10, 17);
        System.out.println(i);
    }


    public int lastRemaining_bak(int n, int m) {
        if (n < 2 || m < 1) return n;

        //int [] arr = new int[n];
        int cur = 0;
       List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        while (arr.size()>1){
            int num = m;
            while (--num>0){
                cur++;
                if (cur >= arr.size())cur=0;
            }
            Integer remove = arr.remove(cur);
            //删除最后一个元素时，cur恢复为0
            if (cur == arr.size()) cur = 0;
            System.out.println(remove);
        }
        return arr.get(0);

    }


    public int lastRemaining(int n, int m) {
        //f(n,m) = (f(n-1,m)+m)%n
        if (n == 1)return 0;
        return (lastRemaining(n-1,m)+m)%n;

    }



    public int lastRemaining1(int n, int m) {
        //f(n,m) = (f(n-1,m)+m)%n
        int res = 0;
        //f(1,m) = 0;
        //f(2,m) = (f(1,m)+m) % 2
        for (int i = 2; i <= n; i++) {
            res = (res+m)%i;
        }
        //res + 0表示编号从0开始；

        //todo ===> 如果编号从6开始，先计算编号从0开始，然后结果再加6
        // res + 6   ====> 编号从6开始！！！！！！！！
        return res + 0;

    }
}
