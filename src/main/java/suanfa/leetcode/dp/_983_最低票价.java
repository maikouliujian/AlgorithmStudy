package suanfa.leetcode.dp;

/**
 * @author lj
 * @createDate 2020/5/6 10:16
 **/
public class _983_最低票价 {
    public static void main(String[] args) {
        int i = new _983_最低票价().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
        System.out.println(i);
    }

    //TODO  :  递推思路===>前面状态要依赖后面，所以要采用倒推
    //TODO 定义dp[i]为从第i天开始，所需的最小费用的累计
    //dp[i] = min(决策1, 决策2, 决策3);
    //      = min(c[0] + 1天后不包, c[1] + 7天后不包, c[2] + 30天不包);
    //      = min(c[0] + dp[i + 1], c[1] + dp[i + 7], c[2] + dp[i + 30]);
    //
    //作者：lzhlyle
    //链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        int len = days.length;
        int minDay = days[0];
        int maxDay = days[len-1];
        int []dp =  new int[maxDay+31];

        //倒着逆推
        int index = len-1;
        for (int i = maxDay; i >= minDay; i--) {
            //出门
            if (days[index] == i){
                dp[i] = Math.min(costs[0]+dp[i+1],Math.min(costs[1]+dp[i+7],costs[2]+dp[i+30]));
                index--;
            }else {
                //不出门
                dp[i] = dp[i+1];

            }

        }
        return dp[minDay];

    }
}
