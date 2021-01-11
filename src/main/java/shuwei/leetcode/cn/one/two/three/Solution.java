package shuwei.leetcode.cn.one.two.three;

import java.util.Arrays;

public class Solution {

    /**
     * 沿用官方的dp思路：
     * 一个数组表示手中持有股票的时候完成几笔的收益
     * 另一个数组表示手中没有股票时候完成几笔的收益
     * 下一天的股票的I次交易的收益非持有: max(i-1次持有 + 本次卖出， i-1次非持有的收益)
     * 下一天的股票的I次交易的收益持有： max(i - 1次非持有 - 本次买入价格, i - 1次持有)
     * 初始化的时候的问题，例如第一天的时候，has[1]和has[2]可能为0
     * 注意j的意义，很可能写错的
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] has = new int[total +1];
        int[] notHas = new int[total + 1];
        // 由于天数少的时候，交易次数不够，所以这里需要统一初始化
        for (int i = 0; i < total + 1; i++) {
            has[i] = -prices[0];
        }
        notHas[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            has[0] = Math.max(has[0], -prices[i]);
            for (int j = 1; j <= total; j++) {
                // 没有卖就没有交易，这里是j-1
                    has[j] = Math.max(notHas[j] - prices[i], has[j]);
                    notHas[j] = Math.max(has[j - 1] + prices[i], notHas[j]);
            }
        }
        // 返回最大值
        return Arrays.stream(notHas).max().getAsInt();
    }
    private static final int total = 2;
}
