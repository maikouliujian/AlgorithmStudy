package xiaomage._第三季_.字符串;

public class good_151_翻转字符串里的单词 {


    /***
     * 思路:1、消除多余的空格：逐位前移，遇到连续的空格，只保留一个！！！
     *      2、编写一个方法，将一定区间范围内的字符串进行逆序；（先对整体字符串逆序，再对每个单词逆序！！！）
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) return s;
        char[] chars = s.trim().toCharArray();
        int cur = 0; //进行存放有效字符
        boolean preBlank = true; //前个字符是否为空,初始值为true，可以处理最开头就是空格的情况；
        int len = 0; //字符串的有效长度
        for (int i = 0; i < chars.length; i++) {
            char v = chars[i];
            if (v == ' '){
                if (!preBlank){
                    chars[cur++] = v;
                }
                preBlank = true;
            }else {
                chars[cur++] = v;
                preBlank = false;
            }
        }
        //TODO :最终的结果：cur要么是有效长度，要么是有效果长度+1；取决于最后一个字符是否为空；
        len = preBlank?cur-1:cur;
        //如果是"              ",则len是-1
        if (len <=0) return "";
        //逆转整个字符数组
        reverse(chars,0,len);


        System.out.println(new String(chars,0,len));

        //逆转每个单词
        //思路：扫描一遍数组，找个每个空格位置
        int preBlankIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' '){
                reverse(chars,preBlankIndex+1,i);
                preBlankIndex = i;
            }
        }
        //TODO :反转最后一个
        reverse(chars,preBlankIndex+1,len);
        //TODO :字节数组转化为字符串
        return new String(chars,0,len);

    }


    /***
     * 将[start,end）区间内的字符串数组逆转
     * 思路：遍历一遍，首尾互换！！！
     * TODO : start不一定是从0开始
     * @param s
     * @param start
     * @param end
     * @return
     */
    public void reverse(char[] chars,int start,int end) {
        if (start > end || chars.length<=1) return;
        //首尾互换，快排的思想
        end--; //变为[start,end]
        while (start<end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
//        for (int i = start; i < end/2; i++) {
//            int j = end -1 -i;
//            char tmp = chars[i];
//            chars[i] = chars[j];
//            chars[j] = tmp;
//        }



    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = "          ";
        String result = new good_151_翻转字符串里的单词().reverseWords(s1);
        System.out.println(result);
    }
}
