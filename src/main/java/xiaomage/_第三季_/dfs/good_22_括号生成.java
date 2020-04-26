package xiaomage._第三季_.dfs;

import java.util.ArrayList;
import java.util.List;

public class good_22_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        char[] tmp = new char[n << 1];
        dfs(0, n, n, tmp, result);

        return result;

    }

    /***
     *
     * @param idx  层级索引
     * @param left  左括号剩余数量
     * @param right 右括号剩余数量
     * @param tmp 辅助数组
     */
    private void dfs(int idx, int left, int right, char[] tmp, List<String> result) {
        if (idx == tmp.length) {
            result.add(new String(tmp));
            return;
        }

        //进行剪枝【要想组成有效的括号组合，首先应该先选择左括号，再选择右括号才行
        // 如果先选择了右括号，则最终结果一定是错误的，需要进行剪枝】
        //TODO left > right 说明 先选择了右括号
        if (left > right) return;

        if (left > 0){
            tmp[idx] = '(';
            dfs(idx+1,left-1,right,tmp,result);
        }


        if (right > 0){
            tmp[idx] = ')';
            dfs(idx+1,left,right-1,tmp,result);
        }


    }
}
