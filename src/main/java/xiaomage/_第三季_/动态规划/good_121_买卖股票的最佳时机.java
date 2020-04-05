package xiaomage._第三季_.动态规划;

public class good_121_买卖股票的最佳时机 {


    /***
     * 思路1：扫描一遍解决====>求出每天卖出的利润，取最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        //求出每天卖出股票的最大值，关键在于求出该天之前股票价格最小值
        //由于只能先买再卖，卖出只能从第二天开始，故默认第一天为最小价格开始
        int min_price = prices[0];
        int max_profile = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<min_price){
                min_price = prices[i];
            }else {
                //大了才卖出
                max_profile = Math.max(max_profile,prices[i] - min_price);
            }
        }
        return max_profile;

    }


    //====>转化为dp问题：最大连续子序列和，同53题

    /***
     * 思路：把股票想象成每天都买，隔天都卖，每天的利润为：当天的价格 - 前一天的价格
     *
     *       求连续的利润和最大值   即为结果
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        //TODO :和53的区别，只有一天，无法卖出，利润为0
        if (prices.length ==1) return 0;
        //dp[i]：以第i天结尾的最大利润和
        int[] dp = new int[prices.length];
        dp[1] = prices[1] - prices[0];
        //TODO :和53的区别，最大利润不能是负值
        int max_profile =  dp[1];
        for (int i = 2; i < prices.length; i++) {
            int profile = prices[i] - prices[i-1];
            dp[i] = dp[i-1]>0?dp[i-1] + profile:profile;
            max_profile = Math.max(dp[i],max_profile);
        }
//TODO :和53的区别，最大利润不能是负值
        return max_profile<0?0:max_profile;

    }
}
