package zuoshen.classics;

/**
 * @author : 刘剑
 * @date : 2021/3/7 7:38 下午
 * @description
 *
 * 有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将 会被覆盖。目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。 返回最少需要涂染几个正方形。
 * 如样例所示: s = RGRGR 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 * todo 【R、G的个数是可以变的】
 */
public class _4正方形染色 {

    // RGRGR -> RRRGG
    // todo 思路：枚举每一个分割点，将分割点左边全部替换为r，分割点右边全部替换为g，求出所有替换步数的最小值
    public static int minPaint(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        //需要知道每个分割点左边g的个数
        //需要知道每个分割点右边r的个数
        //============>
        //<==============
        //因为是从左向右遍历，可以依次计算左边g的个数，但是需要提前计算出总r的个数
        int left = 0,right = 0;
        char[] chars = s.toCharArray();
        //计算总R数
        for (char aChar : chars) {
            right+=aChar == 'R'?1:0;
        }
        //对于分割点的定义，i时，分割点在i到i+1之间
        //左边界时，result为r的总数
        int result = right;
        for (char aChar : chars) {
            left += aChar == 'G' ? 1 : 0;
            right -= aChar == 'R' ? 1 : 0;
            result = Math.min(result,left+right);
        }
        return result;

    }

    // RGRGR -> RRRGG
    public static int minPaint1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int[] right = new int[chs.length];
        right[chs.length - 1] = chs[chs.length - 1] == 'R' ? 1 : 0;
        for (int i = chs.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (chs[i] == 'R' ? 1 : 0);
        }
        int res = right[0];
        int left = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            left += chs[i] == 'G' ? 1 : 0;
            res = Math.min(res, left + right[i + 1]);
        }
        res = Math.min(res, left + (chs[chs.length - 1] == 'G' ? 1 : 0));
        return res;
    }

    public static void main(String[] args) {
        String test = "GGGGGR";
        System.out.println(minPaint(test));
        System.out.println(minPaint1(test));

    }
}
