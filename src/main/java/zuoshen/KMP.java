package zuoshen;

/**
 * @author : 刘剑
 * @date : 2021/2/1 1:30 下午
 * @description 用来判断一个字符串中是否包含另一个字符串
 */
public class KMP {

    public static void main(String[] args) {
        int i = indexOf("abcds", "cd");
        System.out.println(i);
    }

    //text中是否包含pattern
    public static int indexOf(String text, String pattern){
        if (text == null || pattern == null)return -1;
        if (pattern.length() > text.length()) return -1;
        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int[] next = generateNextArray(patternArr);
        int i = 0,j = 0;
        while (i < textArr.length && j < patternArr.length){
            if (textArr[i] == patternArr[j]){
                i++;
                j++;
            }else if (next[j] == -1){ //不相等有两种情况：1、可以从next数组中寻找；2、从next数组中寻找完没找到；
                i++;
                // next[j]==-1等价于j=0
                //j=0;
            }else {
                j = next[j];
            }
        }

        //退出循环
        // 1、匹配成功； j = patternArr.length
        // 2、未找见; j < patternArr.length
        return j == patternArr.length ? i-j:-1;


    }

    //next[i]代表pattern中[0～i-1]的元素中最大公共前后缀的长度,前后缀不包含自己本身！！！
    //根据next[i-1]求next[i]
    private static int[] generateNextArray(char[] patternArr) {
        int [] next = new int[patternArr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;//代表next[i-1]的值，初始化时i=2，next[2-1] = 0;
        while (i < patternArr.length){
            //相等
            if (patternArr[cn] ==patternArr[i-1]){
                next[i++] = ++cn;
                //不相等有两种情况：1、cn  > 0;2、cn <=0
            }else if (cn > 0 ){//cn  > 0
                cn = next[cn];
            }else {//cn <=0
                next[i++] = 0;
            }
        }

        return next;
    }
}
