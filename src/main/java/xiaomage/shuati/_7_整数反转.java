package xiaomage.shuati;

public class _7_整数反转 {



    //TODO:思路====》采用  取模和取余  的方式进行
    public int reverse(int x) {

        long res = 0;
        while (x!=0){
            res = res * 10 +x%10;

            //判断是否溢出
            if (res > Integer.MAX_VALUE) return 0;
            if (res < Integer.MIN_VALUE) return 0;
            x/=10;
        }

        return (int)res;

    }


    public int reverse1(int x) {

        int res = 0;
        while (x!=0){
            int pre = res;
            res = pre * 10 +x%10;

            if ((res - x%10)/10 != pre) return 0;

            //判断是否溢出 ===>如果倒推回去值不变，则没有溢出
//            if (res > Integer.MAX_VALUE) return 0;
//            if (res < Integer.MIN_VALUE) return 0;
            x/=10;
        }

        return res;

    }
}
