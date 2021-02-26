package zuoshen.study.exec;

/**
 * todo 打表法：枚举找规律
 * @author : 刘剑
 * @date : 2021/2/20 6:00 下午
 * @description
 */
public class _dabiao_ {



    public static void main(String[] args) {
        for(int apple = 1; apple < 100;apple++) {
            //System.out.println(apple + " : "+ minBags(apple));
            System.out.println(apple + " : "+ isMSum1(apple));
        }


    }

    /***一、
     *
     *      * 小虎去买苹果，商店只提供两种类型的塑料袋，每种类型都有任意数量。
     *      * 1）能装下6个苹果的袋子
     *      * 2）能装下8个苹果的袋子
     *      * 小虎可以自由使用两种袋子来装苹果，但是小虎有强迫症，他要求自己使用的袋子数量必须最少，且使用的每个袋子必须装满。
     *      * 给定一个正整数N，返回至少使用多少袋子。如果N无法让使用的每个袋子必须装满，返回-1
     * @param apple
     * @return
     * 思路：暴力解：先装8个袋子，剩余的装6个，如果剩余的不满足，则减少8个袋子的数量，再次尝试
     * 如：28   第一次：3 * 8，剩余4 不满足
     *         第二次：2 * 8，剩余12 2 * 6满足
     */
    public static int minBags(int apple) {
        if (apple < 0) return -1;
        int bag8 = apple / 8;
        int rest = apple - bag8 * 8;
        int bag6 = -1;
        while (bag8 >=0 && rest < 24){
            //判断bag6的个数
            bag6 = minBagBase6(rest);
            if (bag6 != -1){
                //说明找见了，直接跳出循环
                break;
            }
            //否则继续遍历寻找,直到全部替换为6袋子
            rest = apple - (--bag8 * 8);
        }
        return bag6 == -1 ? -1: bag8 + bag6;

    }

    //判断使用包6的数，如果能整除则返回，无法整除返回-1
    private static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }


    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) { // 如果是奇数，返回-1
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }


    /***二、
     *
     * 定义一种数：可以表示成若干（数量>1）连续正数和的数
     * 比如:
     * 5 = 2+3，5就是这样的数
     * 12 = 3+4+5，12就是这样的数
     * 1不是这样的数，因为要求数量大于1个、连续正数和
     * 2 = 1 + 1，2也不是，因为等号右边不是连续正数
     * 给定一个参数N，返回是不是可以表示成若干连续正数和的数
     */
    //暴力解：从1开始进行累加，直接大于num，从2开始；
    //一次类推
    public static boolean isMSum1(int num) {

        for (int i = 1; i < num; i++) {//控制从1，2，3，开始加
            int sum = i;
            for (int j = i+1; j < num; j++) {
                sum+=j;
                if (sum == num)return true;
                if (sum > num)break;
            }
        }
        return false;
    }

    public static boolean isMSum2(int num) {
        if (num < 3) {
            return false;
        }
        return (num & (num - 1)) != 0; //如果是2的n次方，false；否则为true；
    }



}
