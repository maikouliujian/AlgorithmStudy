package suanfa.leetcode;

/**
 * @author lj
 * @createDate 2020/5/11 9:10
 **/
public class _50_Pow {

    public static void main(String[] args) {
        double v = new _50_Pow().myPow(2.00000, -4);
        System.out.println(v);
    }


    public double myPow1(double x, int n) {

        if (n ==0) return 1;
        int N = n;
        if (n <0 ){
            N = (-N);
            x = 1/x;

        }
        System.out.println("x-->"+x +"n-->"+N);
        //奇数
        double re = myPow1(x,N/2);
        if ((N & 1) == 1){
            return re*re*x;
        }else {
            return re*re;
        }

    }


    //快速幂  递归调用
    public double myPow(double x, int n) {
        if (n ==0) return 1.0;
        int N = n;
        if (n <0 ){
            x = 1/x;
            N = -N;
        }
        //赋值只改变一次
        return fastPow(x,  N);


    }

    private double fastPow(double x, int n) {
        if (n == 0)return 1.0;
        //奇数
        System.out.println("x--"+x +"n-->"+n);
        double re = fastPow(x,n/2);
        if ((n & 1) == 1){
            return re*re*x;
        }else {
            return re*re;
        }
    }
}
