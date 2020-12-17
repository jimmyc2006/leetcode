package shuwei.leetcode.cn.seven.one.four;

public class Solution {

    /**
     * 总资金为手里资金 + 持有股票的资金
     * 在没有股票的情况下遇到股票就买
     * 在持有股票的情况下，遇到低价的换，换的意思就是股票的价格变成，例如股票的价格是
     * 假设fee是2，股票价格为3,1,6 先持有3，手里资金-3，然后到6的时候卖出，那么赚了6-2为4块钱，4 -3 =1那么赚了1块钱
     * 如果股票3，手里-3的时候遇到1，那么就是股票1，手里-1，到6的时候卖出，变成了赚6-2=4块，手里-1，那么赚了3块钱
     * 所以当遇到更便宜的股票的时候需要换股票
     *
     * 当遇到不等于或者卖出去不赚钱的时候，也就是当前价格>= 股票价格 <= 股票价格+fee的时候，不处理
     *
     * 当遇到股票卖出去有收益的时候，也就是 ： 当前价格 > 股票成本 + fee的时候可以考虑卖出
     * 会有这种情况： 1，7,6,8
     *  如果在1买了，在7卖了赚了5，5-1=4，后面无法盈利
     *  如果在7没有卖，在8的时候卖了，那么能赚5块
     *  这种思路很难算出来
     *
     * ==========上面的贪心思路没有思考好，有待进一步提升==========看过题解以后
     *
     *  换成dp试试，每一步都可能有2种状态，持有股票，不持有股票
     *  例如： 1，7，6，8
     *  1的时候，持有股票的成本是-1，不持有的是0
     *  7的时候，不持有的成本0， 或者卖出去，赚7-2=5块，手里是4
     *      持有那么成本还是-1， -7，选-1
     *  6的时候，不持有4或者卖出赚4块，然后手里4-1=3；
     *      持有的话-2， -1
     *  8的时候，不持有4，或者8-2赚6块，然后 - 1 = 5，最后剩余5块，这种算法貌似可以，每个下标只记录持有和不持有时候的最大收益即可
     *
     *
     *  8的时候，不持有的话延续上一步的4块钱或者
     * @param prices
     * @param fee
     * @return
     */

    public int maxProfitTX(int[] prices, int fee) {
        int ans = 0;
        // buy表示持有时候的最低成本
        int buy = prices[0] + fee;
        for (int i =1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                ans += prices[i] - buy;
                buy = prices[i];
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices, int fee) {
        // 下标0表示不持有时候的最大收益，下标1表示持有时候的最大收益
//        int[][] max = new int[prices.length][2];
        // 优化数组，因为每一步的值只和前面有关
        int a = 0;
        int b = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            a = Math.max(a, b + prices[i] - fee);
            b = Math.max(a - prices[i], b);
        }
        return a;
    }
}
