package zuoshen.经典;

/**
 * @author : 刘剑
 * @date : 2021/3/7 4:40 下午
 * @description
 * 括号有效配对是指：
 * 1）任何一个左括号都能找到和其正确配对的右括号
 * 2）任何一个右括号都能找到和其正确配对的左括号
 * 有效的：    (())  ()()   (()())  等
 * 无效的：     (()   )(     等
 * 问题一：怎么判断一个括号字符串有效？
 * 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 * 问题三：给出一个有效括号串，求最大嵌套深度，如()()一层、(()())二层、(()(()))三层
 */
public class _2括号有效配对 {
    public static void main(String[] args) {
        //boolean check = check("(())()()(()()");
//        int need = needParentheses("(())()()(()()");
//        System.out.println(need);
        //如()()一层、(()())二层、(()(()))三层
        System.out.println(maxDeep("(()(()))"));
    }

    //问题1：思路判断左右括号的个数是否相等
    public static boolean check(String str){
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            count+= aChar == '('?1:-1;
        }
        return count==0;

    }

    //问题2：如果一个括号字符串无效，返回至少填几个字符能让其整体有效

    //todo 思路：维护一个count，一个need，如果count为负数则need++，意思需要'（'来补齐，然后count为0；
    //todo 如果最终count>0,则说明需要'）'补齐；
    //todo 最终结果为：need+count
    public static int needParentheses(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        int need = 0;
        for (char aChar : chars) {
            count+= aChar == '('?1:-1;
            if (count < 0){
                //补充'（'
                need++;
                //补完count 清 0
                count= 0;
            }
        }
        return count + need;
    }

    //问题三：给出一个有效括号串，求最大嵌套深度，如()()一层、(()())二层、(()(()))三层
    //todo 寻找连续'('的个数
    public static int maxDeep(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        int result = 0;
        for (char aChar : chars) {
            count+= aChar == '('?1:-1;
            result = Math.max(count,result);

        }
        return result;
    }





}
