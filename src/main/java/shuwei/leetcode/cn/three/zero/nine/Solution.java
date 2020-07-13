package shuwei.leetcode.cn.three.zero.nine;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length < 1) {
      return 0;
    }
    int[][] f = new int[prices.length][3];
    f[0][0] = -prices[0];
    f[0][1] = 0;
    f[0][2] = 0;
    for (int i = 1; i < prices.length; i++) {
      // 有股票的收益，股票可能本次购买也可能是上一次购买的
      f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - prices[i]);
      // 手里没有股票，非静默
      f[i][1] = Math.max(f[i - 1][1], f[i - 1][2]);
      // 手里没股票，静默
      f[i][2] = f[i - 1][0] + prices[i];
    }
    return Math.max(f[prices.length - 1][1], f[prices.length - 1][2]);
  }
}
