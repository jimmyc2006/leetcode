package shuwei.leetcode.cn.one.two.two;

public class Solution1108 {

  /**
   * 只要有收益就计算
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int ans = 0;
    int curr = Integer.MAX_VALUE;
    for (int ele : prices) {
      if (ele < curr) {
        curr = ele;
      } else if (ele > curr) {
        ans += ele - curr;
        curr = ele;
      }
    }
    return ans;
  }

  /**
   * dp：每一步都需要计算可执行操作对应的最大收益
   * 购买： 不持有的时候直接购买，持有的时候先卖出再购买
   * 卖出： 变为不持有状态
   * 每一步dp有3个数据，持有的时候当前最大收益，不持有的时候当前最大收益
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }
    int[][] max = new int[prices.length][];
    int hasIndex = 0;
    int noIndex = 1;
    for (int i = 0; i < prices.length; i++) {
      max[i] = new int[2];
    }
    max[0][hasIndex] = -prices[0];
    max[0][noIndex] = 0;
    for (int i = 1 ; i < prices.length; i++) {
      max[i][hasIndex] = Math.max(max[i - 1][hasIndex], max[i - 1][noIndex] - prices[i]);
      max[i][noIndex] = Math.max(max[i - 1][hasIndex] + prices[i], max[i - 1][noIndex]);
    }
    return max[prices.length - 1][noIndex];
  }

}
