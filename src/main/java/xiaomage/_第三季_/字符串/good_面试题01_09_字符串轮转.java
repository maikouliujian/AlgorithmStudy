package xiaomage._第三季_.字符串;

public class good_面试题01_09_字符串轮转 {

    /***
     * 思路  ： 对一个字符串进行拼接，判断另一个是否在拼接串中
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1 ==null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        return  (s1 + s1).contains(s2);

    }
}
