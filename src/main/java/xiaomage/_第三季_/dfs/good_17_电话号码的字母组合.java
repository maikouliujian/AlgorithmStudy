package xiaomage._第三季_.dfs;

import java.util.ArrayList;
import java.util.List;

public class good_17_电话号码的字母组合 {

    public static void main(String[] args) {
        List<String> strings = new good_17_电话号码的字母组合().letterCombinations("23");
        System.out.println(strings);
    }

    char [][] letters = new char[][]{
            {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };



    //TODO : 思路：深度优先遍历,每一个字符都有对应的层级
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null) return result;

        char[] chars = digits.toCharArray();
        if (chars.length == 0)return result;
        char[] tmp = new char[chars.length];
        dfs(0,chars,result,tmp);

        return result;

    }

    private void dfs(int idx, char[] chars, List<String> result,char[] tmp) {
        //递归终止条件；递归终止，自动向上回溯
        int len = chars.length;
        if (idx == len){
            result.add(new String(tmp));
            return;
        }

        //处理每一层级元素
        char letter = chars[idx];
        char[] level_chars = letters[letter - '2'];
        for (int i = 0; i < level_chars.length; i++) {
            tmp[idx] = level_chars[i];
            dfs(idx+1,chars,result,tmp);
        }

    }
}
