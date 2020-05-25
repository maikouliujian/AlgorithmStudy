package xiaomage.shuati;

public class _50_Pow {

    public static void main(String[] args) {
        double v = new _50_Pow().myPow(-2, -2);
        System.out.println(v);
    }



    //TODO : 思路 快速幂 采用分治
    public double myPow(double x, int n) {
        //由于n可以是正或者负，负数不好处理，统一转为正数
        int N = n;
        if (N < 0){
            N = -N;
            x = 1/x;
        }

       return fastPow(x,N);

    }

    private double fastPow(double x, int n) {
        if (n == 0) return 1.0;
        int half = n>>1;
        double re = fastPow(x,half);
        if ((n & 1) ==1){
            return re * re * x;
        }else {
            return re*re;
        }

    }



    //TODO : 思路 快速幂 采用二进制方式求
    public double myPow1(double x, int n) {
        //由于n可以是正或者负，负数不好处理，统一转为正数
        long N = n;  //改成long是因为 n 是 32 位有符号整数，其数值范围是 [−2^31, 2^(31 − 1)] 。 int取不到2^31
        if (N < 0){
            N = -N;
            x = 1/x;
        }

        double result  = 1.0;
        while (N > 0){

            //N的二进制位最后一位为1，则值有效
            if ((N &1) ==1){
                result*=x;
            }
            x*=x;
            //N向右移动1位，剔除之前的最后一位；
            N>>=1;
        }

        return result;
    }

}
