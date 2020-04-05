package xiaomage._第二季_._字符串;


/***
 * 判断一个串中是否含有另一个串！！！！
 */
public class KMP {

    public static void main(String[] args) {
        int i = indexOf("abcds", "cd");
        System.out.println(i);
    }

    public static int indexOf(String text, String pattern){
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        //通过parttern得到next表
        //todo next表的使用：是在匹配过程中，出现了不匹配情况，向后移动parttern时使用；
        int[] next = next(pattern);


        int ti = 0;
        int pi = 0;
        int lenDelta = tlen - plen;
        while (ti - pi<= lenDelta && pi<plen ){
            if (pi< 0 || textChars[ti] == patternChars[pi]){
                ti++;
                pi++;
            }else {
                pi = next[pi];
            }
        }
        //当匹配成功时pi == plen，要退出循环；
        return pi == plen ? ti - pi:-1;
    }

    /***
     * todo 重点！！！
     * 针对parttern计算next数组
     * @param pattern
     * @return
     */
    private static int[] next(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        //初始化
        //next[i] = n;
        next[0] = -1;
        int i = 0;
        int iMax = chars.length -1;

        int n = -1;  //next[1] =0;
        while (i < iMax){
            if (n < 0 || chars[i] == chars[n]){
                next[++i] = ++n;
            }else {
                n = next[n];
            }
        }
        return next;
    }


    private static int[] next2(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        //初始化
        //next[i] = n;
        next[0] = -1;
        int i = 0;
        int iMax = chars.length -1;

        int n = -1;  //next[1] =0;
        while (i < iMax){
            if (n < 0 || chars[i] == chars[n]){
                //next[++i] = ++n;
                i++;
                n++;
                if (chars[i] == chars[n]){
                    next[i] = next[n];
                }else {
                    next[i] = n;
                }
            }else {
                n = next[n];
            }
        }
        return next;
    }
}
