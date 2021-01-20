package suanfa.leetcode.dp;

/**
 * @author lj
 * @createDate 2019/8/20 11:00
 *
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class _121_买卖股票的最佳时机 {

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        //int[] prices = new int[]{7,6,4,3,1};
        int result = s.maxProfit2(prices);
        System.out.println(result);


    }

    /***
     * 解法一 # todo 转化为   分别求最大值和最小值的解法
     * @return
     */
    public static class Solution {
        public int maxProfit(int prices[]) {

            int minValue = Integer.MAX_VALUE;
            int maxProfile = 0;
            for (int i = 0; i < prices.length; i++) {
                //求最小值
                int cur = prices[i];
                if (cur < minValue){
                    minValue = cur;
                }else if (cur  - minValue > maxProfile){
                    maxProfile = cur - minValue;
                }
            }

            return maxProfile;


        }


        /***
         * 解法二 # todo 转化为   子数组最大和问题  【这个得仔细看看！！！】
         * @return
         */
// Kadane algorithm to solve Maximum subArray problem
        public int maxProfit2(int[] prices) {
            int maxEndingHere = 0, maxSoFar = 0;
            for (int i = 1; i < prices.length; i++) {
                maxEndingHere += prices[i] - prices[i - 1];
                maxEndingHere = Math.max(maxEndingHere, 0);
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
            return maxSoFar;
        }


        //TODO 求出最大值和最小值；
        public int maxProfitReview(int[] prices) {
            //维护两个变量，分别求出最大值和最小值
            int minValue = Integer.MAX_VALUE;
            int maxProfile = 0;

            for (int i = 0; i <prices.length; i++) {
                int tmp = prices[i];
                if (tmp < minValue){
                   minValue = tmp;
                }else if (tmp - minValue> maxProfile){
                    maxProfile = tmp- minValue;
                }
            }
            return maxProfile;
        }
    }
    /***
     * todo 子数组最大和问题
     *https://www.cnblogs.com/en-heng/p/3970231.html
     *
     */





}
