package xiaomage._第二季_._字符串;

public class BruteForce01 {

    public static void main(String[] args) {
        int i = indexOf("abcds", "ce");
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


        int ti = 0;
        int pi = 0;
        while (ti<tlen&&pi<plen ){
//            //当pi走到parttern的尾部，则匹配结束，返回起始位置；
//            if (pi == plen -1) return ti - pi;
            if (textChars[ti] == patternChars[pi]){
                ti++;
                pi++;
            }else {
                pi = 0;
                //ti回到起点的下一位
                ti = ti- pi+1;
            }
        }
        //当匹配成功时pi == plen，要退出循环；
        return pi == plen ? ti - pi:-1;
    }


    public static int indexOf1(String text, String pattern){
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;


        int ti = 0;
        int pi = 0, lenDelta = tlen - plen;
        while (pi<plen &&ti-pi <= lenDelta){
            if (textChars[ti] == patternChars[pi]){
                ti++;
                pi++;
            }else {
                pi = 0;
                //ti回到起点的下一位
                ti = ti- pi+1;
            }
        }
        //当匹配成功时pi == plen，要退出循环；
        return pi == plen ? ti - pi:-1;
    }
}
